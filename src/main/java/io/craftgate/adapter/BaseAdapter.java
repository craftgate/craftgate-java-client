package io.craftgate.adapter;

import io.craftgate.request.common.HashGenerator;
import io.craftgate.request.common.RequestContext;
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
    private static final String IDEMPOTENCY_KEY = "x-idempotency-key";

    protected final RequestOptions requestOptions;

    protected BaseAdapter(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    protected Map<String, String> createHeaders(Object request, String path) {
        return createHttpHeaders(request, path, null);
    }

    protected Map<String, String> createHeaders(Object request, String path, RequestContext requestContext) {
        return createHttpHeaders(request, path, requestContext);
    }

    protected Map<String, String> createHeaders(String path) {
        return createHttpHeaders(null, path, null);
    }

    protected Map<String, String> createHeaders(String path, RequestContext requestContext) {
        return createHttpHeaders(null, path, requestContext);
    }

    private Map<String, String> createHttpHeaders(Object request, String path, RequestContext requestContext) {
        Map<String, String> headers = new HashMap<>();

        String randomString = UUID.randomUUID().toString();
        headers.put(API_KEY_HEADER_NAME, requestOptions.getApiKey());
        headers.put(RANDOM_HEADER_NAME, randomString);
        headers.put(AUTH_VERSION_HEADER_NAME, API_VERSION_HEADER_VALUE);
        headers.put(CLIENT_VERSION_HEADER_NAME, CLIENT_VERSION_HEADER_VALUE + ":1.0.79");
        headers.put(SIGNATURE_HEADER_NAME, prepareAuthorizationString(request, path, randomString));
        if (Objects.nonNull(requestOptions.getLanguage())) {
            headers.put(LANGUAGE_HEADER_NAME, requestOptions.getLanguage());
        }
        if (Objects.nonNull(requestContext) && Objects.nonNull(requestContext.getIdempotencyKey())) {
            headers.put(IDEMPOTENCY_KEY, requestContext.getIdempotencyKey());
        }
        return headers;
    }

    private String prepareAuthorizationString(Object request, String path, String randomString) {
        return HashGenerator.generateHash(requestOptions.getBaseUrl(), requestOptions.getApiKey(), requestOptions.getSecretKey(), randomString, request, path);
    }
}
