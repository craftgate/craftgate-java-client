package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.model.PaymentProvider;
import io.craftgate.request.*;
import io.craftgate.request.dto.MasterpassCreatePayment;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.CheckMasterpassUserResponse;
import io.craftgate.response.MasterpassPaymentThreeDSInitResponse;
import io.craftgate.response.MasterpassPaymentTokenGenerateResponse;
import io.craftgate.response.PaymentResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MasterpassSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void check_masterpass_user() {
        CheckMasterpassUserRequest request = CheckMasterpassUserRequest.builder()
                .masterpassGsmNumber("903000000000")
                .build();

        CheckMasterpassUserResponse response = craftgate.masterpass().checkMasterpassUser(request);
        assertNotNull(response);
    }

    @Test
    void generate_masterpass_payment_token() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .build());

        MasterpassPaymentTokenGenerateRequest request = MasterpassPaymentTokenGenerateRequest.builder()
                .userId("masterpass-user-id")
                .msisdn("900000000000")
                .binNumber("404308")
                .forceThreeDS(false)
                .createPayment(MasterpassCreatePayment.builder()
                        .price(BigDecimal.valueOf(100))
                        .paidPrice(BigDecimal.valueOf(100))
                        .installment(1)
                        .currency(Currency.TRY)
                        .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                        .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                        .paymentPhase(PaymentPhase.AUTH)
                        .items(items)
                        .build())
                .build();

        MasterpassPaymentTokenGenerateResponse response = craftgate.masterpass().generateMasterpassPaymentToken(request);
        assertNotNull(response.getReferenceId());
        assertNotNull(response.getOrderNo());
        assertNotNull(response.getToken());
    }

    @Test
    void complete_masterpass_payment() {
        MasterpassPaymentCompleteRequest request = MasterpassPaymentCompleteRequest.builder()
                .referenceId("referenceId")
                .token("token")
                .build();

        PaymentResponse response = craftgate.masterpass().completeMasterpassPayment(request);
        assertNotNull(response.getId());
        assertEquals(PaymentProvider.MASTERPASS, response.getPaymentProvider());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getFraudId());
        assertNull(response.getFraudAction());
        assertNull(response.getPaymentError());
    }

    @Test
    void init_3ds_masterpass_payment() {
        MasterpassPaymentThreeDSInitRequest request = MasterpassPaymentThreeDSInitRequest.builder()
                .referenceId("referenceId")
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .build();

        MasterpassPaymentThreeDSInitResponse response = craftgate.masterpass().init3DSMasterpassPayment(request);
        assertNotNull(response.getReturnUrl());
    }

    @Test
    void complete_3ds_masterpass_payment() {
        MasterpassPaymentThreeDSCompleteRequest request = MasterpassPaymentThreeDSCompleteRequest.builder()
                .paymentId(1L)
                .build();

        PaymentResponse response = craftgate.masterpass().complete3DSMasterpassPayment(request);
        assertNotNull(response.getId());
        assertEquals(PaymentProvider.MASTERPASS, response.getPaymentProvider());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getFraudId());
        assertNull(response.getFraudAction());
        assertNull(response.getPaymentError());
    }
}
