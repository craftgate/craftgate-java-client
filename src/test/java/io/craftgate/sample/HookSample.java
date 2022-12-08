package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.WebhookData;
import io.craftgate.model.WebhookEventType;
import io.craftgate.model.WebhookStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HookSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void should_verify_webhook_signature() {
        //given
        String merchantHookKey = "Aoh7tReTybO6wOjBmOJFFsOR53SBojEp";
        String incomingSignature = "0wRB5XqWJxwwPbn5Z9TcbHh8EGYFufSYTsRMB74N094=";

        LocalDateTime eventTime = LocalDateTime.of(2022, 8, 26, 16, 40, 21, 395655000);
        WebhookData webhookData = WebhookData.builder()
                .eventType(WebhookEventType.API_VERIFY_AND_AUTH)
                .eventTime(eventTime)
                .eventTimestamp(1661521221L)
                .status(WebhookStatus.SUCCESS)
                .payloadId("584")
                .build();

        //when
        boolean isWebhookVerified = craftgate.hook().isWebhookVerified(merchantHookKey, incomingSignature, webhookData);

        //then
        assertTrue(isWebhookVerified);
    }

    @Test
    void should_not_verify_webhook_signature() {
        //given
        String merchantHookKey = "Aoh7tReTybO6wOjBmOJFFsOR53SBojEp";
        String incomingSignature = "Bsa498wcnaasd4bhx8anxıxcsdnxanalkdjcahxhd";

        LocalDateTime eventTime = LocalDateTime.of(2022, 8, 26, 16, 40, 21, 395655000);
        WebhookData webhookData = WebhookData.builder()
                .eventType(WebhookEventType.API_VERIFY_AND_AUTH)
                .eventTime(eventTime)
                .eventTimestamp(1661521221L)
                .status(WebhookStatus.SUCCESS)
                .payloadId("584")
                .build();

        //when
        boolean isWebhookVerified = craftgate.hook().isWebhookVerified(merchantHookKey, incomingSignature, webhookData);

        //then
        assertFalse(isWebhookVerified);
    }
}
