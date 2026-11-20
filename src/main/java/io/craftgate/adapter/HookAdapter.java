package io.craftgate.adapter;

import io.craftgate.model.WebhookData;
import io.craftgate.request.common.RequestOptions;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Clock;
import java.time.Duration;
import java.util.Objects;

public class HookAdapter extends BaseAdapter {

    private final Clock clock;

    public HookAdapter(RequestOptions requestOptions) {
        this(requestOptions, Clock.systemUTC());
    }

    HookAdapter(RequestOptions requestOptions, Clock clock) {
        super(requestOptions);
        this.clock = clock;
    }

    /**
     * Verifies the webhook signature only. It does not protect against replayed webhooks;
     * prefer {@link #isWebhookVerified(String, String, WebhookData, Duration)} and ignore payloadIds already processed.
     */
    public boolean isWebhookVerified(String merchantHookKey, String incomingSignature, WebhookData webhookData) {
        if (Objects.isNull(merchantHookKey) || Objects.isNull(incomingSignature) || Objects.isNull(webhookData)
                || Objects.isNull(webhookData.getEventTimestamp())) {
            return false;
        }

        String data = webhookData.getEventType() + webhookData.getEventTimestamp().toString() + webhookData.getStatus() + webhookData.getPayloadId();
        String signature = generateHash(merchantHookKey, data);
        if (Objects.isNull(signature)) {
            return false;
        }
        return MessageDigest.isEqual(
                signature.getBytes(StandardCharsets.UTF_8),
                incomingSignature.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Verifies the webhook signature and rejects webhooks whose eventTimestamp is further than
     * {@code tolerance} away from the current time, which limits replaying captured webhooks.
     */
    public boolean isWebhookVerified(String merchantHookKey, String incomingSignature, WebhookData webhookData, Duration tolerance) {
        if (Objects.isNull(tolerance) || tolerance.isNegative()) {
            throw new IllegalArgumentException("tolerance must be a non-negative duration");
        }
        if (!isWebhookVerified(merchantHookKey, incomingSignature, webhookData)) {
            return false;
        }
        long nowInSeconds = clock.millis() / 1000;
        long ageInSeconds = Math.abs(nowInSeconds - webhookData.getEventTimestamp());
        return ageInSeconds <= tolerance.getSeconds();
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
