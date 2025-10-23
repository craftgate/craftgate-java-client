package io.craftgate.request.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.craftgate.exception.CraftgateException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String baseUrl, String apiKey, String secretKey, String randomString, Object request, String path) {
        try {
            String hashData;
            String decodedUrl = URLDecoder.decode(baseUrl + path, StandardCharsets.UTF_8.toString());

            if (request != null) {
                Gson gson = buildGson();
                String requestBody = gson.toJson(request);
                hashData = decodedUrl + apiKey + secretKey + randomString + requestBody;
            } else {
                hashData = decodedUrl + apiKey + secretKey + randomString;
            }

            return Base64.encodeBase64String(DigestUtils.sha256(hashData));
        } catch (Exception e) {
            throw new CraftgateException(e);
        }
    }

    public static String generateHash(String hashString) {
        try {
            return DigestUtils.sha256Hex(hashString);
        } catch (Exception e) {
            throw new CraftgateException(e);
        }
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (com.google.gson.JsonSerializer<LocalDateTime>) (localDateTime, typeOfSrc, context) ->
                        context.serialize(localDateTime.toString()))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                        LocalDateTime.parse(json.getAsString()))                .create();
    }
}
