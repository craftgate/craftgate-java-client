package io.craftgate.net;

public enum HttpMethod {

    GET,
    POST,
    DELETE,
    PUT;

    public static boolean hasBody(HttpMethod httpMethod) {
        return !GET.equals(httpMethod);
    }
}
