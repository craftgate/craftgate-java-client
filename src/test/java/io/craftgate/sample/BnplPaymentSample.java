package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmType;
import io.craftgate.model.BnplCartItemType;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.request.BnplPaymentOfferRequest;
import io.craftgate.request.InitBnplPaymentRequest;
import io.craftgate.request.dto.BnplPaymentCartItem;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.BnplPaymentOfferResponse;
import io.craftgate.response.BnplPaymentVerifyResponse;
import io.craftgate.response.InitBnplPaymentResponse;
import io.craftgate.response.PaymentResponse;
import io.craftgate.response.dto.BnplBankOffer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BnplPaymentSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_bank_offer() {
        List<BnplPaymentCartItem> items = new ArrayList<>();

        items.add(BnplPaymentCartItem.builder()
                .id("1234")
                .name("item 1")
                .brandName("Iphone")
                .type(BnplCartItemType.MOBILE_PHONE_PRICE_BELOW_REGULATION_LIMIT)
                .unitPrice(BigDecimal.valueOf(3000))
                .quantity(2)
                .build());
        items.add(BnplPaymentCartItem.builder()
                .id("123")
                .name("item 2")
                .brandName("Samsung")
                .type(BnplCartItemType.OTHER)
                .unitPrice(BigDecimal.valueOf(4000))
                .quantity(1)
                .build());

        BnplPaymentOfferRequest request = BnplPaymentOfferRequest.builder()
                .apmType(ApmType.MASLAK)
                .price(BigDecimal.valueOf(10000))
                .currency(Currency.TRY)
                .apmOrderId(UUID.randomUUID().toString())
                .items(items)
                .build();

        BnplPaymentOfferResponse response = craftgate.payment().retrieveBnplPaymentOffers(request);
        assertNotNull(response.getOfferId());
        BnplBankOffer bnplBankOffer = response.getBankOffers().get(0);
        assertNotNull(bnplBankOffer);
    }


    @Test
    void init_bnpl_payment() {
        BigDecimal price = new BigDecimal("10000");

        List<PaymentItem> paymentItemRequests = new ArrayList<>();
        paymentItemRequests.add(PaymentItem.builder()
                .name("item-1")
                .externalId("38983903")
                .price(new BigDecimal("3000"))
                .build());
        paymentItemRequests.add(PaymentItem.builder()
                .name("item-2")
                .externalId("92983294")
                .price(new BigDecimal("7000"))
                .build());

        List<BnplPaymentCartItem> items = new ArrayList<>();
        items.add(BnplPaymentCartItem.builder()
                .id("200")
                .name("Test Elektronik 2")
                .brandName("iphone")
                .type(BnplCartItemType.OTHER)
                .unitPrice(new BigDecimal("7000"))
                .quantity(2)
                .build());
        items.add(BnplPaymentCartItem.builder()
                .id("100")
                .name("Test Elektronik 1")
                .brandName("Samsung")
                .type(BnplCartItemType.MOBILE_PHONE_PRICE_ABOVE_REGULATION_LIMIT)
                .unitPrice(new BigDecimal("3000"))
                .quantity(1)
                .build());
        InitBnplPaymentRequest request = InitBnplPaymentRequest.builder()
                .price(price)
                .paidPrice(price)
                .currency(Currency.TRY)
                .apmType(ApmType.MASLAK)
                .apmOrderId(UUID.randomUUID().toString())
                .paymentGroup(PaymentGroup.PRODUCT)
                .conversationId("29393-mXld92ko3")
                .externalId("external_id-345")
                .callbackUrl("callback")
                .items(paymentItemRequests)
                .bankCode("103")
                .cartItems(items)
                .build();

        InitBnplPaymentResponse response = craftgate.payment().initBnplPayment(request);
        assertNotNull(response.getRedirectUrl());
    }

    @Test
    void init_tom_finance_bnpl_payment() {
        BigDecimal price = new BigDecimal("100");

        Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("buyerName", "John Doe");
        additionalParams.put("buyerPhoneNumber", "5551112233");

        List<PaymentItem> paymentItemRequests = new ArrayList<>();
        paymentItemRequests.add(PaymentItem.builder()
                .name("item-1")
                .externalId("externalId")
                .price(new BigDecimal("100"))
                .build());

        List<BnplPaymentCartItem> items = new ArrayList<>();
        items.add(BnplPaymentCartItem.builder()
                .id("26020874")
                .name("Item 1")
                .brandName("26010303")
                .type(BnplCartItemType.OTHER)
                .unitPrice(new BigDecimal("100"))
                .quantity(1)
                .build());
        InitBnplPaymentRequest request = InitBnplPaymentRequest.builder()
                .price(price)
                .paidPrice(price)
                .currency(Currency.TRY)
                .apmType(ApmType.TOM_FINANCE)
                .apmOrderId(UUID.randomUUID().toString())
                .paymentGroup(PaymentGroup.PRODUCT)
                .conversationId("conversationId")
                .externalId("externalId")
                .callbackUrl("https://www.your-website.com/bnpl-callback")
                .items(paymentItemRequests)
                .cartItems(items)
                .additionalParams(additionalParams)
                .build();

        InitBnplPaymentResponse response = craftgate.payment().initBnplPayment(request);
        assertNotNull(response.getRedirectUrl());
    }

    @Test
    void approve_bnpl_payment() {
        Long paymentId = 1L;
        PaymentResponse response = craftgate.payment().approveBnplPayment(paymentId);
        assertNotNull(response.getId());
    }

    @Test
    void verify_bnpl_payment() {
        Long paymentId = 1L;
        BnplPaymentVerifyResponse response = craftgate.payment().verifyBnplPayment(paymentId);
        assertNotNull(response.getPaymentStatus());
    }
}
