package io.craftgate.adapter;

import io.craftgate.model.WebhookData;
import io.craftgate.model.WebhookEventType;
import io.craftgate.model.WebhookStatus;
import io.craftgate.request.common.RequestOptions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HookAdapterTest {

    private static final String MERCHANT_HOOK_KEY = "Aoh7tReTybO6wOjBmOJFFsOR53SBojEp";
    private static final String VALID_SIGNATURE = "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N094=";
    private static final long EVENT_TIMESTAMP = 1661521221L;

    private final RequestOptions requestOptions = RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build();

    private static WebhookData webhookData(Long eventTimestamp) {
        return WebhookData.builder()
                .eventType(WebhookEventType.API_VERIFY_AND_AUTH)
                .eventTimestamp(eventTimestamp)
                .status(WebhookStatus.SUCCESS)
                .payloadId("584")
                .build();
    }

    private HookAdapter adapterAt(long epochSeconds) {
        return new HookAdapter(requestOptions, Clock.fixed(Instant.ofEpochSecond(epochSeconds), ZoneOffset.UTC));
    }

    @Test
    void verifies_valid_signature() {
        assertTrue(new HookAdapter(requestOptions).isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP)));
    }

    @Test
    void rejects_invalid_signature() {
        HookAdapter adapter = new HookAdapter(requestOptions);
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N095=", webhookData(EVENT_TIMESTAMP)));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "", webhookData(EVENT_TIMESTAMP)));
    }

    @Test
    void rejects_missing_event_timestamp_without_throwing() {
        assertFalse(new HookAdapter(requestOptions).isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(null)));
    }

    @Test
    void accepts_signed_webhook_within_tolerance() {
        HookAdapter adapter = adapterAt(EVENT_TIMESTAMP + 299);
        assertTrue(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP), Duration.ofMinutes(5)));
    }

    @Test
    void rejects_signed_webhook_outside_tolerance() {
        HookAdapter adapter = adapterAt(EVENT_TIMESTAMP + 301);
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP), Duration.ofMinutes(5)));
    }

    @Test
    void rejects_unsigned_webhook_within_tolerance() {
        HookAdapter adapter = adapterAt(EVENT_TIMESTAMP);
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "invalid", webhookData(EVENT_TIMESTAMP), Duration.ofMinutes(5)));
    }

    @Test
    void rejects_negative_tolerance() {
        HookAdapter adapter = adapterAt(EVENT_TIMESTAMP);
        assertThrows(IllegalArgumentException.class, () ->
                adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData(EVENT_TIMESTAMP), Duration.ofSeconds(-1)));
    }
}
