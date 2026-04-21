package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.ApmType;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.dto.MealVoucherCardTokenizationData;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealVoucherCardTokenizationSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void init_meal_voucher_card_tokenization() {
        MealVoucherCardTokenizationInitRequest request = MealVoucherCardTokenizationInitRequest.builder()
                .apmType(ApmType.SETCARD)
                .mealVoucherCardTokenizationData(MealVoucherCardTokenizationData.buildForSetcard("https://www.your-website.com/craftgate-mealvoucher-card-tokenization-callback"))
                .build();

        MealVoucherCardTokenizationInitResponse response = craftgate.mealVoucherCardTokenizationAdapter().cardTokenizationInit(request);

        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getSessionId());
        assertEquals(ApmAdditionalAction.SHOW_HTML_CONTENT, response.getAdditionalAction());
    }
}
