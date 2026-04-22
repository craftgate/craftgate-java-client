package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.ApmType;
import io.craftgate.request.MealVoucherCardTokenizationCompleteRequest;
import io.craftgate.request.MealVoucherCardTokenizationInitRequest;
import io.craftgate.request.MealVoucherCardTokenizationRegenerateRequest;
import io.craftgate.request.MealVoucherCardTokenizationCompleteResponse;
import io.craftgate.request.dto.MealVoucherCardTokenizationData;
import io.craftgate.response.MealVoucherCardTokenizationInitResponse;
import io.craftgate.response.MealVoucherCardTokenizationRegenerateResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealVoucherCardTokenizationSample {

    private final Craftgate craftgate = new Craftgate("api-key-2", "secret-key", "http://localhost:8000");

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

    @Test
    void regenerate_meal_voucher_card_tokenization() {
        String sessionId = "session-id";
        MealVoucherCardTokenizationRegenerateRequest request = MealVoucherCardTokenizationRegenerateRequest.builder()
                .mealVoucherCardTokenizationData(MealVoucherCardTokenizationData.buildForMetropol("6375780115068760", "5556667788"))
                .build();

        MealVoucherCardTokenizationRegenerateResponse response = craftgate.mealVoucherCardTokenizationAdapter().cardTokenizationRegenerate(sessionId, request);

        assertNotNull(response.getSessionId());
        assertEquals(ApmAdditionalAction.OTP_REQUIRED, response.getAdditionalAction());
    }

    @Test
    void complete_meal_voucher_card_tokenization() {
        String sessionId = "session-id";
        MealVoucherCardTokenizationCompleteRequest request = MealVoucherCardTokenizationCompleteRequest.builder()
                .validationCode("123456")
                .build();

        MealVoucherCardTokenizationCompleteResponse response = craftgate.mealVoucherCardTokenizationAdapter().cardTokenizationComplete(sessionId, request);

        assertNotNull(response.getSessionId());
        assertNotNull(response.getMaskedCardNumber());
        assertNotNull(response.getFingerprint());
        assertNotNull(response.getBalance());
    }
}
