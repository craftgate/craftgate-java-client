package io.craftgate.adapter;

import io.craftgate.model.WebhookData;
import io.craftgate.model.WebhookEventType;
import io.craftgate.model.WebhookStatus;
import io.craftgate.request.common.RequestOptions;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HookAdapterTest {

    private static final String MERCHANT_HOOK_KEY = "Aoh7tReTybO6wOjBmOJFFsOR53SBojEp";
    private static final String VALID_SIGNATURE = "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N094=";
    private static final long EVENT_TIMESTAMP = 1661521221L;

    private final HookAdapter adapter = new HookAdapter(RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build());

    private static WebhookData webhookData(Long eventTimestamp) {
        return WebhookData.builder()
                .eventType(WebhookEventType.API_VERIFY_AND_AUTH)
                .eventTimestamp(eventTimestamp)
                .status(WebhookStatus.SUCCESS)
                .payloadId("584")
                .build();
    }

    private static String sign(WebhookData data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(MERCHANT_HOOK_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        String payload = data.getEventType() + data.getEventTimestamp().toString() + data.getStatus() + data.getPayloadId();
        return Base64.encodeBase64String(mac.doFinal(payload.getBytes(StandardCharsets.UTF_8)));
    }

    private static long nowInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Test
    void verifies_valid_signature() {
        assertTrue(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP)));
    }

    @Test
    void rejects_invalid_signature() {
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N095=", webhookData(EVENT_TIMESTAMP)));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "", webhookData(EVENT_TIMESTAMP)));
    }

    @Test
    void accepts_signed_webhook_within_tolerance() throws Exception {
        WebhookData data = webhookData(nowInSeconds() - 60);
        assertTrue(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, sign(data), data, Duration.ofMinutes(5)));
    }

    @Test
    void rejects_signed_webhook_outside_tolerance() throws Exception {
        WebhookData old = webhookData(nowInSeconds() - 600);
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, sign(old), old, Duration.ofMinutes(5)));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP), Duration.ofMinutes(5)));
    }

    @Test
    void rejects_unsigned_webhook_within_tolerance() {
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "invalid", webhookData(nowInSeconds()), Duration.ofMinutes(5)));
    }

    @Test
    void rejects_negative_tolerance() {
        assertThrows(IllegalArgumentException.class, () ->
                adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP), Duration.ofSeconds(-1)));
    }
}
