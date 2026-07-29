package io.craftgate.adapter;

import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.RequestOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseAdapter {

    private static final String API_VERSION_HEADER_VALUE = "v1";
    private static final String CLIENT_VERSION_HEADER_VALUE = "craftgate-java-client";
    private static final String API_KEY_HEADER_NAME = "x-api-key";
    private static final String RANDOM_HEADER_NAME = "x-rnd-key";
    private static final String AUTH_VERSION_HEADER_NAME = "x-auth-version";
    private static final String CLIENT_VERSION_HEADER_NAME = "x-client-version";
    private static final String SIGNATURE_HEADER_NAME = "x-signature";
    private static final String LANGUAGE_HEADER_NAME = "lang";
    private static final String IDEMPOTENCY_KEY_HEADER_NAME = "x-idempotency-key";

    protected final RequestOptions requestOptions;

    protected BaseAdapter(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    /**
     * Headers for a request that carries a body. The body is hashed for the signature and its
     * idempotency key, when present, is sent as a header.
     */
    protected Map<String, String> createHeaders(BaseRequest request, String path, RequestOptions requestOptions) {
        return createHttpHeaders(request, path, requestOptions, request.getIdempotencyKey());
    }

    /**
     * Headers for a body-less request (e.g. GET). No body is hashed and no idempotency key is sent.
     */
    protected Map<String, String> createHeaders(String path, RequestOptions requestOptions) {
        return createHttpHeaders(null, path, requestOptions, null);
    }

    /**
     * Headers for a body-less mutating request (e.g. DELETE, or a POST/PUT whose parameters live in
     * the path). The {@code request} wrapper is <b>not</b> hashed or sent as a body — only its
     * idempotency key is used, so the signature stays identical to the body-less call the server expects.
     */
    protected Map<String, String> createHeaders(String path, RequestOptions requestOptions, BaseRequest request) {
        return createHttpHeaders(null, path, requestOptions, request.getIdempotencyKey());
    }

    private static Map<String, String> createHttpHeaders(Object request, String path, RequestOptions options, String idempotencyKey) {
        Map<String, String> headers = new HashMap<>();

        String randomString = UUID.randomUUID().toString();
        headers.put(API_KEY_HEADER_NAME, options.getApiKey());
        headers.put(RANDOM_HEADER_NAME, randomString);
        headers.put(AUTH_VERSION_HEADER_NAME, API_VERSION_HEADER_VALUE);
        headers.put(CLIENT_VERSION_HEADER_NAME, CLIENT_VERSION_HEADER_VALUE + ":1.0.81");
        headers.put(SIGNATURE_HEADER_NAME, prepareAuthorizationString(request, path, randomString, options));
        if (Objects.nonNull(options.getLanguage())) {
            headers.put(LANGUAGE_HEADER_NAME, options.getLanguage());
        }
        if (Objects.nonNull(idempotencyKey)) {
            headers.put(IDEMPOTENCY_KEY_HEADER_NAME, idempotencyKey);
        }
        return headers;
    }

    private static String prepareAuthorizationString(Object request, String path, String randomString, RequestOptions options) {
        return HashGenerator.generateHash(options.getBaseUrl(), options.getApiKey(), options.getSecretKey(), randomString, request, path);
    }
}
