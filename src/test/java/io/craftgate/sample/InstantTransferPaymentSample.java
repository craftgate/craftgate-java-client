package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.*;
import io.craftgate.request.InitApmPaymentRequest;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.ApmPaymentInitResponse;
import io.craftgate.response.InstantTransferBank;
import io.craftgate.response.InstantTransferBanksResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class InstantTransferPaymentSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_active_banks() {
        InstantTransferBanksResponse response = craftgate.payment().retrieveActiveBanks();
        assertNotNull(response.getItems());
        InstantTransferBank instantTransferBank = response.getItems().get(0);
        assertNotNull(instantTransferBank);
    }

    @Test
    void init_instant_transfer_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.60))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.40))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.INSTANT_TRANSFER)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .additionalParams(new HashMap() {{
                    put("bankCode", "0");
                }})
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNull(response.getRedirectUrl());
        assertNotNull(response.getHtmlContent());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.SHOW_HTML_CONTENT, response.getAdditionalAction());
    }
}
