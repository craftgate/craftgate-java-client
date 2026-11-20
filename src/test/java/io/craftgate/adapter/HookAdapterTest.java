package io.craftgate.adapter;

import io.craftgate.model.WebhookData;
import io.craftgate.model.WebhookEventType;
import io.craftgate.model.WebhookStatus;
import io.craftgate.request.common.RequestOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HookAdapterTest {

    private static final String MERCHANT_HOOK_KEY = "Aoh7tReTybO6wOjBmOJFFsOR53SBojEp";
    private static final String VALID_SIGNATURE = "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N094=";

    private final HookAdapter adapter = new HookAdapter(RequestOptions.builder()
            .apiKey("api-key")
            .secretKey("secret-key")
            .baseUrl("https://sandbox-api.craftgate.io")
            .build());

    private static WebhookData webhookData() {
        return WebhookData.builder()
                .eventType(WebhookEventType.API_VERIFY_AND_AUTH)
                .eventTimestamp(1661521221L)
                .status(WebhookStatus.SUCCESS)
                .payloadId("584")
                .build();
    }

    @Test
    void verifies_valid_signature() {
        assertTrue(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, webhookData()));
    }

    @Test
    void rejects_invalid_signature() {
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N095=", webhookData()));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, "", webhookData()));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE.substring(1), webhookData()));
    }

    @Test
    void rejects_missing_arguments() {
        assertFalse(adapter.isWebhookVerified(null, VALID_SIGNATURE, webhookData()));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, null, webhookData()));
        assertFalse(adapter.isWebhookVerified(MERCHANT_HOOK_KEY, VALID_SIGNATURE, null));
    }
}
