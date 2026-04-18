package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmType;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealVoucherCardTokenizationSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void init_meal_voucher_card_tokenization() {
        MealVoucherCardTokenizationInitRequest request = MealVoucherCardTokenizationInitRequest.builder()
                .apmType(ApmType.SETCARD)
                .mealVoucherIdentifier(UUID.randomUUID().toString())
                .callbackUrl("https://www.your-website.com/craftgate-mealvoucher-card-tokenization-callback")
                .build();

        MealVoucherCardTokenizationInitResponse response = craftgate.mealVoucherCardTokenizationAdapter().cardTokenizationInit(request);

        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getSessionId());
        assertNotNull(response.getRedirectUrl());
        assertNotNull(response.getAdditionalAction());
    }
}
