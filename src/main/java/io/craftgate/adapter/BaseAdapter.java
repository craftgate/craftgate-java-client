package io.craftgate.adapter;

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

    protected final RequestOptions requestOptions;

    public BaseAdapter(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    protected Map<String, String> createHeaders(Object request, String path, RequestOptions requestOptions) {
        return createHttpHeaders(request, path, requestOptions);
    }

    protected Map<String, String> createHeaders(String path, RequestOptions requestOptions) {
        return createHttpHeaders(null, path, requestOptions);
    }

    private static Map<String, String> createHttpHeaders(Object request, String path, RequestOptions options) {
        Map<String, String> headers = new HashMap<>();

        String randomString = UUID.randomUUID().toString();
        headers.put(API_KEY_HEADER_NAME, options.getApiKey());
        headers.put(RANDOM_HEADER_NAME, randomString);
        headers.put(AUTH_VERSION_HEADER_NAME, API_VERSION_HEADER_VALUE);
        headers.put(CLIENT_VERSION_HEADER_NAME, CLIENT_VERSION_HEADER_VALUE + ":1.0.28");
        headers.put(SIGNATURE_HEADER_NAME, prepareAuthorizationString(request, path, randomString, options));
        if (Objects.nonNull(options.getLanguage())) {
            headers.put(LANGUAGE_HEADER_NAME, options.getLanguage());
        }
        return headers;
    }

    private static String prepareAuthorizationString(Object request, String path, String randomString, RequestOptions options) {
        return HashGenerator.generateHash(options.getBaseUrl(), options.getApiKey(), options.getSecretKey(), randomString, request, path);
    }
}
