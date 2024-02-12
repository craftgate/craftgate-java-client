package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.*;
import io.craftgate.request.InitJuzdanPaymentRequest;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.InitJuzdanPaymentResponse;
import io.craftgate.response.PaymentResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JuzdanSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void init() {
        List<PaymentItem> items = new LinkedList<>();

        PaymentItem paymentItem = PaymentItem.builder()
                .price(BigDecimal.ONE)
                .name("test123")
                .externalId("test2")
                .build();

        items.add(paymentItem);

        InitJuzdanPaymentRequest initJuzdanPaymentRequest = InitJuzdanPaymentRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.PRODUCT)
                .conversationId("testConversationId")
                .externalId("testExternalId")
                .callbackUrl("www.testCallbackUrl.com")
                .clientType(InitJuzdanPaymentRequest.ClientType.W)
                .items(items)
                .paymentPhase(PaymentPhase.AUTH)
                .paymentChannel("testPaymentChannel")
                .bankOrderId("testBankOrderId")
                .build();

        InitJuzdanPaymentResponse initResponse = assertDoesNotThrow(() -> craftgate.juzdan().init(initJuzdanPaymentRequest));
        assertNotNull(initResponse);
        assertNotNull(initResponse.getJuzdanQrUrl());
        assertNotNull(initResponse.getReferenceId());
    }

    @Test
    void retrieve() {

        String referenceId = "5493c7a7-4d8b-4517-887d-f8b8f826a3d0";

        PaymentResponse paymentResponse = assertDoesNotThrow(() -> craftgate.juzdan().retrieve(referenceId));

        assertNotNull(paymentResponse);
        assertEquals(PaymentSource.JUZDAN, paymentResponse.getPaymentSource());
        assertEquals(PaymentType.CARD_PAYMENT, paymentResponse.getPaymentType());
    }

}
