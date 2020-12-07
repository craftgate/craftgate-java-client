package io.craftgate.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.craftgate.exception.CraftgateException;
import io.craftgate.response.common.ErrorResponse;
import io.craftgate.response.common.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;

public class HttpClient {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final int CONNECT_TIMEOUT = 15000;
    private static final int READ_TIMEOUT = 140000;
    private static final Gson gson = buildGson();

    private HttpClient() {
    }

    public static <T> T get(String url, Map<String, String> headers, Class<T> responseType) {
        return exchange(url, HttpMethod.GET, headers, null, responseType);
    }

    public static <T> T post(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, HttpMethod.POST, headers, request, responseType);
    }

    public static <T> T put(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, HttpMethod.PUT, headers, request, responseType);
    }

    public static void delete(String url, Map<String, String> headers) {
        exchange(url, HttpMethod.DELETE, headers, null, Void.class);
    }

    private static <T> T exchange(String url, HttpMethod httpMethod, Map<String, String> headers, Object request, Class<T> responseType) {
        try {
            String body = gson.toJson(request);
            InputStream content = request == null ? null : new ByteArrayInputStream(body.getBytes(DEFAULT_CHARSET));
            final HttpResponse httpResponse = send(url, httpMethod, content, headers);
            return handleResponse(httpResponse, responseType);
        } catch (CraftgateException e) {
            throw e;
        } catch (Exception e) {
            throw new CraftgateException(e);
        }
    }

    private static <T> T handleResponse(HttpResponse httpResponse, Class<T> responseType) {
        Response response = gson.fromJson(httpResponse.getBody(), Response.class);

        if (httpResponse.getStatusCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            if (response != null && response.getErrors() != null) {
                ErrorResponse errors = response.getErrors();
                throw new CraftgateException(errors.getErrorCode(), errors.getErrorDescription(), errors.getErrorGroup());
            }
            throw new CraftgateException();
        }

        if (responseType == Void.class) {
            return null;
        } else if (response == null) {
            throw new CraftgateException("1", "Empty response", "Unknown");
        }

        return gson.fromJson(response.getData(), responseType);
    }

    private static HttpResponse send(String url, HttpMethod httpMethod, InputStream content, Map<String, String> headers) throws IOException {
        URLConnection raw;
        HttpURLConnection conn = null;
        try {
            raw = new URL(url).openConnection();
            conn = (HttpURLConnection) raw;

            conn.setRequestMethod(httpMethod.name());
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);

            prepareHeaders(headers, conn);
            if (content != null) {
                prepareRequestBody(httpMethod, content, conn);
            }

            final int responseCode = conn.getResponseCode();
            final String responseBody = new String(body(conn), StandardCharsets.UTF_8);
            return new HttpResponse(responseCode, responseBody);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static void prepareHeaders(Map<String, String> headers, HttpURLConnection conn) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            conn.addRequestProperty(header.getKey(), header.getValue());
        }

        conn.addRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
        conn.addRequestProperty(ACCEPT, APPLICATION_JSON);
    }

    private static void prepareRequestBody(HttpMethod httpMethod, InputStream content, HttpURLConnection conn) throws IOException {
        if (HttpMethod.hasBody(httpMethod)) {
            conn.setDoOutput(true);
            final OutputStream output = conn.getOutputStream();
            try {
                prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        }
    }

    private static void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        final byte[] buffer = new byte[16384];
        for (int bytes = content.read(buffer); bytes != -1;
             bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }
    }

    private static byte[] body(HttpURLConnection conn) throws IOException {
        final InputStream input;
        if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            input = conn.getErrorStream();
        } else {
            input = conn.getInputStream();
        }
        final byte[] body;
        if (input == null) {
            body = new byte[0];
        } else {
            try {
                final byte[] buffer = new byte[16384];
                final ByteArrayOutputStream output = new ByteArrayOutputStream();
                for (int bytes = input.read(buffer); bytes != -1;
                     bytes = input.read(buffer)) {
                    output.write(buffer, 0, bytes);
                }
                body = output.toByteArray();
            } finally {
                input.close();
            }
        }
        return body;
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString()))
                .create();
    }
}

class HttpResponse {

    int statusCode;
    String body;

    public HttpResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
