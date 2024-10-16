package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmStatus;
import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import io.craftgate.request.CreateMerchantApmRequest;
import io.craftgate.request.UpdateMerchantApmRequest;
import io.craftgate.request.UpdateMerchantApmStatusRequest;
import io.craftgate.response.MerchantApmListResponse;
import io.craftgate.response.MerchantApmResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MerchantApmSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_merchant_apm() {
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("apiKey", "api-key-2");
                put("secretKey", "secret-key");
            }
        };

        CreateMerchantApmRequest request = CreateMerchantApmRequest.builder()
                .status(ApmStatus.ACTIVE)
                .name("my test apm")
                .apmType(ApmType.PAPARA)
                .hostname("https://merchant-api.papara.com")
                .supportedCurrencies(Arrays.asList(
                        Currency.TRY,
                        Currency.USD,
                        Currency.EUR,
                        Currency.GBP
                ))
                .properties(map)
                .build();

        MerchantApmResponse response = craftgate.merchantApm().createMerchantApm(request);
        assertNotNull(response.getId());
        assertNotNull(response.getHostname());
        assertNotNull(response.getApmType());
    }

    @Test
    void update_merchant_apm() {
        Long merchantApmId = 22L;

        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("apiKey", "api-key-2");
                put("secretKey", "secret-key");
            }
        };

        UpdateMerchantApmRequest request = UpdateMerchantApmRequest.builder()
                .name("my updated test apm")
                .status(ApmStatus.ACTIVE)
                .hostname("https://merchant-api.papara.com")
                .supportedCurrencies(Arrays.asList(
                        Currency.TRY,
                        Currency.USD,
                        Currency.EUR,
                        Currency.GBP
                ))
                .properties(map)
                .build();

        MerchantApmResponse response = craftgate.merchantApm().updateMerchantApm(merchantApmId, request);
        assertNotNull(response.getId());
        assertNotNull(response.getHostname());
        assertNotNull(response.getApmType());
        assertEquals(response.getApmType(), ApmType.PAPARA);
    }

    @Test
    void update_merchant_apm_status() {
        Long merchantApmId = 22L;

        UpdateMerchantApmStatusRequest request = UpdateMerchantApmStatusRequest.builder()
                .status(ApmStatus.PASSIVE)
                .build();

        craftgate.merchantApm().updateMerchantApmStatus(merchantApmId, request);
    }

    @Test
    void retrieve_merchant_apm() {
        MerchantApmListResponse response = craftgate.merchantApm().retrieveAll();

        assertNotNull(response);
    }

    @Test
    void delete_merchant_apm() {
        Long merchantApmId = 22L;

        craftgate.merchantApm().deleteMerchantApm(merchantApmId);
    }
}
