package io.craftgate.adapter;

import io.craftgate.model.WebhookData;
import io.craftgate.request.common.RequestOptions;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HookAdapter extends BaseAdapter {

    public HookAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public boolean isWebhookVerified(String merchantHookKey, String incomingSignature, WebhookData webhookData) {
        if(Objects.isNull(merchantHookKey) || Objects.isNull(incomingSignature) || Objects.isNull(webhookData)){
            return false;
        }

        String data = webhookData.getEventType() + webhookData.getEventTimestamp().toString() + webhookData.getStatus() + webhookData.getPayloadId();
        String signature = generateHash(merchantHookKey, data);
        return incomingSignature.equals(signature);
    }

    private String generateHash(String merchantHookKey, String data) {
        try {
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(merchantHookKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmacSHA256.init(secretKey);
            byte[] sha256 = hmacSHA256.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeBase64String(sha256);
        } catch (Exception e) {
            return null;
        }
    }
}