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

    protected Map<String, String> createHeaders(BaseRequest request, String path, RequestOptions requestOptions) {
        return createHttpHeaders(request, path, requestOptions, request);
    }

    protected Map<String, String> createHeaders(String path, RequestOptions requestOptions) {
        return createHttpHeaders(null, path, requestOptions, null);
    }

    /**
     * Headers for a mutating request that sends no body. {@code options} supplies the
     * request-scoped options and is never hashed or sent, so the signature stays that of a
     * body-less call.
     */
    protected Map<String, String> createHeadersWithoutBody(String path, RequestOptions requestOptions, BaseRequest options) {
        return createHttpHeaders(null, path, requestOptions, options);
    }

    /**
     * Headers for a request whose body differs from the wrapper carrying the request-scoped
     * options, e.g. when a path variable lives on the wrapper but not in the body.
     */
    protected Map<String, String> createHeaders(BaseRequest request, String path, RequestOptions requestOptions, BaseRequest options) {
        return createHttpHeaders(request, path, requestOptions, options);
    }

    private static Map<String, String> createHttpHeaders(Object request, String path, RequestOptions options, BaseRequest scopedOptions) {
        Map<String, String> headers = new HashMap<>();

        String randomString = UUID.randomUUID().toString();
        headers.put(API_KEY_HEADER_NAME, options.getApiKey());
        headers.put(RANDOM_HEADER_NAME, randomString);
        headers.put(AUTH_VERSION_HEADER_NAME, API_VERSION_HEADER_VALUE);
        headers.put(CLIENT_VERSION_HEADER_NAME, CLIENT_VERSION_HEADER_VALUE + ":1.0.82");
        headers.put(SIGNATURE_HEADER_NAME, prepareAuthorizationString(request, path, randomString, options));
        if (Objects.nonNull(options.getLanguage())) {
            headers.put(LANGUAGE_HEADER_NAME, options.getLanguage());
        }
        applyRequestScopedHeaders(headers, scopedOptions);
        return headers;
    }

    /**
     * Applies the options that travel as headers rather than in the payload. New request-scoped
     * options are added here and nowhere else.
     */
    private static void applyRequestScopedHeaders(Map<String, String> headers, BaseRequest options) {
        if (Objects.isNull(options)) {
            return;
        }
        if (Objects.nonNull(options.getIdempotencyKey())) {
            headers.put(IDEMPOTENCY_KEY_HEADER_NAME, options.getIdempotencyKey());
        }
    }

    private static String prepareAuthorizationString(Object request, String path, String randomString, RequestOptions options) {
        return HashGenerator.generateHash(options.getBaseUrl(), options.getApiKey(), options.getSecretKey(), randomString, request, path);
    }
}
