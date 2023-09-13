package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmType;
import io.craftgate.request.CreatePaymentTokenRequest;
import io.craftgate.response.PaymentTokenResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentTokenSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_payment_token() {
        CreatePaymentTokenRequest request = CreatePaymentTokenRequest.builder()
                .value("value-to-be-tokenized")
                .issuer("EDENRED")
                .build();

        PaymentTokenResponse response = craftgate.paymentTokenAdapter().createPaymentToken(request);

        assertEquals(response.getIssuer(), ApmType.EDENRED.name());
        assertNotNull(response.getToken());
    }

    @Test
    void delete_payment_token() {
        String token = "token-to-be-deleted";

        craftgate.paymentTokenAdapter().deletePaymentToken(token);
    }
}
