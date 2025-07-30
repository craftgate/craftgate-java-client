package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.response.MerchantApmListResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MerchantApmSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_merchant_apms() {
        MerchantApmListResponse response = craftgate.merchantApm().retrieveApms();

        assertNotNull(response);
    }
}
