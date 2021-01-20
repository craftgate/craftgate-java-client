package io.craftgate.request.common;

import com.google.gson.Gson;
import io.craftgate.exception.CraftgateException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String baseUrl, String apiKey, String secretKey, String randomString, Object request, String path) {
        try {
            String hashData;
            String decodedUrl = URLDecoder.decode(baseUrl + path, StandardCharsets.UTF_8.toString());

            if (request != null) {
                Gson gson = new Gson();
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
}
