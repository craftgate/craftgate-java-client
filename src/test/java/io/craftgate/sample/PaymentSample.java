package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.*;
import io.craftgate.request.*;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.GarantiPayInstallment;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_payment() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(PaymentSource.API, response.getPaymentSource());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getFraudId());
        assertNull(response.getFraudAction());
        assertNull(response.getPaymentError());
    }

    @Test
    void create_marketplace_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantMemberId(1L)
                .subMerchantMemberPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantMemberId(2L)
                .subMerchantMemberPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantMemberId(3L)
                .subMerchantMemberPrice(BigDecimal.valueOf(18))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void create_payment_and_store_card() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("external_id-123456789")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .storeCardAfterSuccessPayment(true)
                        .cardAlias("My YKB Card")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(request.getConversationId(), response.getConversationId());
        assertEquals(request.getExternalId(), response.getExternalId());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNotNull(response.getCardUserKey());
        assertNotNull(response.getCardToken());
    }

    @Test
    void create_payment_using_stored_card() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                        .cardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(true, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void create_payment_using_external_payment_provider_stored_card() {
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

        Map<String, Object> additionalParams = new HashMap<>();
        Map<String, Object> paymentProviderParams = new HashMap<>();
        paymentProviderParams.put("cardUserKey", "test-cardUserKey");
        paymentProviderParams.put("cardToken", "tuz8imxv30");
        additionalParams.put("paymentProvider", paymentProviderParams);

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .posAlias("6007-posAlias-1")
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("external_id-123456789")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .items(items)
                .additionalParams(additionalParams)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(request.getExternalId(), response.getExternalId());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getBinNumber());
        assertNull(response.getLastFourDigits());
        assertNull(response.getCardType());
        assertNull(response.getCardAssociation());
        assertNull(response.getCardBrand());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void create_payment_with_loyalty() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("4043080000000003")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .loyalty(Loyalty.builder()
                                .type(LoyaltyType.REWARD_MONEY)
                                .reward(Reward.builder()
                                        .cardRewardMoney(new BigDecimal("1.36"))
                                        .firmRewardMoney(new BigDecimal("3.88"))
                                        .build()
                                )
                                .build())
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(PaymentSource.API, response.getPaymentSource());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("404308", response.getBinNumber());
        assertEquals("0003", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.VISA, response.getCardAssociation());
        assertEquals("Bonus", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
        assertNotNull(response.getLoyalty());
        assertEquals(LoyaltyType.REWARD_MONEY, response.getLoyalty().getType());
        assertNotNull(response.getLoyalty().getReward());
        assertEquals(new BigDecimal("1.36"), response.getLoyalty().getReward().getCardRewardMoney());
        assertEquals(new BigDecimal("3.88"), response.getLoyalty().getReward().getFirmRewardMoney());
    }

    @Test
    void create_payment_with_postponing_payment_loyalty() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("9792675000000002")
                        .expireYear("2025")
                        .expireMonth("06")
                        .cvc("000")
                        .loyalty(Loyalty.builder()
                                .type(LoyaltyType.POSTPONING_PAYMENT)
                                .loyaltyParams(LoyaltyParams.builder()
                                        .postponingPaymentCount(90)
                                        .build())
                                .build())
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(PaymentSource.API, response.getPaymentSource());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("97926750", response.getBinNumber());
        assertEquals("0002", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.TROY, response.getCardAssociation());
        assertEquals("KuveytTürk CC", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
        assertNotNull(response.getLoyalty());
        assertEquals(LoyaltyType.POSTPONING_PAYMENT, response.getLoyalty().getType());
    }

    @Test
    void create_payment_with_first6_last4_and_identityNumber() {
        List<PaymentItem> items = new ArrayList<>();
        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(100))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderIdentityNumber("12345678900")
                        .binNumber("404308")
                        .lastFourDigits("0003")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(PaymentSource.API, response.getPaymentSource());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("404308", response.getBinNumber());
        assertEquals("0003", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.VISA, response.getCardAssociation());
        assertEquals("Bonus", response.getCardBrand());
        assertEquals(1, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
    }

    @Test
    void init_3DS_payment() {
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

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
        assertNotNull(response.getPaymentId());
    }

    @Test
    void init_3DS_marketplace_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantMemberId(1L)
                .subMerchantMemberPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantMemberId(2L)
                .subMerchantMemberPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantMemberId(3L)
                .subMerchantMemberPrice(BigDecimal.valueOf(18))
                .build());

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
        assertNotNull(response.getPaymentId());
    }

    @Test
    void init_3DS_payment_and_store_card() {
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

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .storeCardAfterSuccessPayment(true)
                        .cardAlias("My YKB Card")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
        assertNotNull(response.getPaymentId());
    }

    @Test
    void init_3DS_payment_using_stored_card() {
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

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                        .cardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
        assertNotNull(response.getPaymentId());
    }

    @Test
    void complete_3DS_payment() {
        CompleteThreeDSPaymentRequest request = CompleteThreeDSPaymentRequest.builder()
                .paymentId(1L)
                .build();

        PaymentResponse response = craftgate.payment().complete3DSPayment(request);
        assertNotNull(response);
    }

    @Test
    void init_checkout_payment() {
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

        InitCheckoutPaymentRequest request = InitCheckoutPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .buyerMemberId(1L)
                .callbackUrl("https://www.your-website.com/craftgate-checkout-callback")
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .items(items)
                .build();

        InitCheckoutPaymentResponse response = craftgate.payment().initCheckoutPayment(request);

        assertNotNull(response);
        assertNotNull(response.getPageUrl());
        assertNotNull(response.getToken());
        assertNotNull(response.getTokenExpireDate());
    }

    @Test
    void init_checkout_payment_for_deposit() {
        InitCheckoutPaymentRequest request = InitCheckoutPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .buyerMemberId(1L)
                .callbackUrl("https://www.your-website.com/craftgate-checkout-callback")
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .depositPayment(true)
                .build();

        InitCheckoutPaymentResponse response = craftgate.payment().initCheckoutPayment(request);

        assertNotNull(response);
        assertNotNull(response.getPageUrl());
        assertNotNull(response.getToken());
        assertNotNull(response.getTokenExpireDate());
    }

    @Test
    void retrieve_checkout_payment() {
        String token = "456d1297-908e-4bd6-a13b-4be31a6e47d5";

        PaymentResponse response = craftgate.payment().retrieveCheckoutPayment(token);

        assertNotNull(response);
    }

    @Test
    void expire_checkout_payment() {
        String token = "456d1297-908e-4bd6-a13b-4be31a6e47d5";

        craftgate.payment().expireCheckoutPayment(token);
    }

    @Test
    void create_deposit_payment() {
        CreateDepositPaymentRequest request = CreateDepositPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .buyerMemberId(1L)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .build();

        DepositPaymentResponse response = craftgate.payment().createDepositPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getBuyerMemberId(), response.getBuyerMemberId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
        assertEquals(PaymentType.DEPOSIT_PAYMENT, response.getPaymentType());
    }

    @Test
    void init_3DS_deposit_payment() {
        CreateDepositPaymentRequest request = CreateDepositPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .buyerMemberId(1L)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSDepositPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
        assertNotNull(response.getPaymentId());
    }

    @Test
    void complete_3DS_deposit_payment() {
        CompleteThreeDSPaymentRequest request = CompleteThreeDSPaymentRequest.builder()
                .paymentId(1L)
                .build();

        DepositPaymentResponse response = craftgate.payment().complete3DSDepositPayment(request);
        assertNotNull(response);
        assertEquals(BigDecimal.valueOf(100), response.getPrice());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
        assertEquals(PaymentType.DEPOSIT_PAYMENT, response.getPaymentType());
    }

    @Test
    void create_fund_transfer_deposit_payment() {
        CreateFundTransferDepositPaymentRequest request = CreateFundTransferDepositPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .buyerMemberId(1L)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .build();

        FundTransferDepositPaymentResponse response = craftgate.payment().createFundTransferDepositPayment(request);

        assertEquals(request.getBuyerMemberId(), response.getBuyerMemberId());
        assertEquals(new BigDecimal("100.00000000"), response.getPrice());
        assertEquals(request.getConversationId(), response.getConversationId());
        assertNotNull(response.getWalletTransaction());
        assertEquals(WalletTransactionType.DEPOSIT_FROM_FUND_TRANSFER, response.getWalletTransaction().getWalletTransactionType());
    }

    @Test
    void init_apm_deposit_payment() {
        InitApmDepositPaymentRequest request = InitApmDepositPaymentRequest.builder()
                .apmType(ApmType.PAPARA)
                .price(BigDecimal.valueOf(1))
                .currency(Currency.TRY)
                .buyerMemberId(1L)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .clientIp("127.0.0.1")
                .build();

        ApmDepositPaymentResponse response = craftgate.payment().initApmDepositPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getRedirectUrl());
        assertEquals(response.getPaymentStatus(), PaymentStatus.WAITING);
        assertEquals(response.getAdditionalAction(), ApmAdditionalAction.REDIRECT_TO_URL);
    }

    @Test
    void init_garanti_pay_payment() {
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

        List<GarantiPayInstallment> installments = new ArrayList<>();

        installments.add(GarantiPayInstallment.builder()
                .number(2)
                .totalPrice(BigDecimal.valueOf(120))
                .build()
        );
        installments.add(GarantiPayInstallment.builder()
                .number(3)
                .totalPrice(BigDecimal.valueOf(125))
                .build()
        );

        InitGarantiPayPaymentRequest request = InitGarantiPayPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .callbackUrl("https://www.your-website.com/craftgate-garantipay-callback")
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .items(items)
                .installments(installments)
                .enabledInstallments(Arrays.asList(2, 3))
                .build();

        InitGarantiPayPaymentResponse response = craftgate.payment().initGarantiPayPayment(request);

        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getDecodedHtmlContent());
    }

    @Test
    void init_apm_payment() {
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
                .apmType(ApmType.PAPARA)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getRedirectUrl());
        assertEquals(response.getPaymentStatus(), PaymentStatus.WAITING);
        assertEquals(response.getAdditionalAction(), ApmAdditionalAction.REDIRECT_TO_URL);
    }

    @Test
    void init_sodexo_apm_payment() {
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
                .apmType(ApmType.SODEXO)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .apmUserIdentity("5555555555")
                .additionalParams(new HashMap() {{
                    put("sodexoCode", "843195");
                }})
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNull(response.getRedirectUrl());
        assertEquals(response.getPaymentStatus(), PaymentStatus.SUCCESS);
        assertEquals(response.getAdditionalAction(), ApmAdditionalAction.NONE);
    }

    @Test
    void init_edenred_apm_payment() {
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
                .apmType(ApmType.EDENRED)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .apmUserIdentity("6036819041742253")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNull(response.getRedirectUrl());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.OTP_REQUIRED, response.getAdditionalAction());
    }

    @Test
    void complete_edenred_apm_payment() {
        CompleteApmPaymentRequest request = CompleteApmPaymentRequest.builder()
                .paymentId(1L)
                .additionalParams(new HashMap() {{
                    put("otpCode", "784294");
                }})
                .build();

        ApmPaymentCompleteResponse response = craftgate.payment().completeApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
    }

    @Test
    void init_paypal_apm_payment() {
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
                .apmType(ApmType.PAYPAL)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.USD)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNull(response.getRedirectUrl());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void init_klarna_apm_payment() {
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

        Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("country", "de");
        additionalParams.put("locale", "en-DE");

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.KLARNA)
                .price(BigDecimal.valueOf(1))
                .paidPrice(BigDecimal.valueOf(1))
                .currency(Currency.EUR)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .additionalParams(additionalParams)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getRedirectUrl());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void init_afterpay_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.AFTERPAY)
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.USD)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getRedirectUrl());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void init_metropol_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(1.00))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.METROPOL)
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("myConversationId")
                .externalId("optional-externalId")
                .items(items)
                .additionalParams(new HashMap() {{
                    put("cardNumber", "6375780115068760");
                }})
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getAdditionalData());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.OTP_REQUIRED, response.getAdditionalAction());
    }

    @Test
    void complete_metropol_apm_payment() {
        CompleteApmPaymentRequest request = CompleteApmPaymentRequest.builder()
                .paymentId(1L)
                .additionalParams(new HashMap() {{
                    put("otpCode", "00000");
                    put("productId", "1");
                    put("walletId", "1");
                }})
                .build();

        ApmPaymentCompleteResponse response = craftgate.payment().completeApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
    }

    @Test
    void init_kaspi_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.KASPI)
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.KZT)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .externalId("optional-externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getRedirectUrl());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void init_tompay_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.TOMPAY)
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("conversationId")
                .externalId("externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .additionalParams(new HashMap() {{
                    put("channel", "channel");
                    put("phone", "5001112233");
                }})
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.WAIT_FOR_WEBHOOK, response.getAdditionalAction());
    }

    @Test
    void init_chippin_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.CHIPPIN)
                .apmUserIdentity("1000000")  // Chippin Kullanıcı numarası
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("conversationId")
                .externalId("externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.WAIT_FOR_WEBHOOK, response.getAdditionalAction());
    }

    @Test
    void init_bizum_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("buyerPhoneNumber", "34700000000");

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.BIZUM)
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.EUR)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("conversationId")
                .externalId("externalId")
                .additionalParams(additionalParams)
                .items(items)
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.WAIT_FOR_WEBHOOK, response.getAdditionalAction());
    }


    @Test
    void init_paymob_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.TEN)
                .build());

        InitApmPaymentRequest request = InitApmPaymentRequest.builder()
                .apmType(ApmType.PAYMOB)
                .price(BigDecimal.TEN)
                .paidPrice(BigDecimal.TEN)
                .currency(Currency.EGP)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("conversationId")
                .externalId("externalId")
                .callbackUrl("https://www.your-website.com/craftgate-apm-callback")
                .items(items)
                .additionalParams(new HashMap() {{
                    put("integrationId", "11223344");
                }})
                .build();

        ApmPaymentInitResponse response = craftgate.payment().initApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(ApmAdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void init_ykb_world_pay_pos_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitPosApmPaymentRequest request = InitPosApmPaymentRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentProvider(PosApmPaymentProvider.YKB_WORLD_PAY)
                .additionalParams(new HashMap() {{
                    put("sourceCode", "WEB2QR");
                }})
                .callbackUrl("https://www.your-website.com/craftgate-pos-apm-callback")
                .items(items)
                .build();

        InitPosApmPaymentResponse response = craftgate.payment().initPosApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getHtmlContent());
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(AdditionalAction.SHOW_HTML_CONTENT, response.getAdditionalAction());
    }

    @Test
    void init_garanti_pay_pos_apm_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.6))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.4))
                .build());

        InitPosApmPaymentRequest request = InitPosApmPaymentRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentProvider(PosApmPaymentProvider.GARANTI_PAY)
                .additionalParams(new HashMap() {{
                    put("integrationType", "WEB2APP");
                }})
                .callbackUrl("https://www.your-website.com/craftgate-pos-apm-callback")
                .items(items)
                .build();

        InitPosApmPaymentResponse response = craftgate.payment().initPosApmPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getAdditionalData().get("redirectUrl"));
        assertEquals(PaymentStatus.WAITING, response.getPaymentStatus());
        assertEquals(AdditionalAction.REDIRECT_TO_URL, response.getAdditionalAction());
    }

    @Test
    void complete_pos_apm_payment() {
        CompletePosApmPaymentRequest request = CompletePosApmPaymentRequest.builder()
                .paymentId(1L)
                .build();

        PaymentResponse response = craftgate.payment().completePosApmPayment(request);
        assertNotNull(response);
    }

    @Test
    void create_cash_on_delivery_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(60))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(40))
                .build());

        CreateApmPaymentRequest request = CreateApmPaymentRequest.builder()
                .apmType(ApmType.CASH_ON_DELIVERY)
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("241cf73c-7ef1-4e29-a6cc-f37905f2fc3d")
                .externalId("optional-externalId")
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createApmPayment(request);
        assertNotNull(response.getId());
        assertEquals(new BigDecimal("100.00000000"), response.getPrice());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
        assertEquals(PaymentType.APM, response.getPaymentType());
        assertEquals("241cf73c-7ef1-4e29-a6cc-f37905f2fc3d", response.getConversationId());
        assertEquals(2, response.getPaymentTransactions().size());
    }

    @Test
    void create_fund_transfer_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(60))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(40))
                .build());

        CreateApmPaymentRequest request = CreateApmPaymentRequest.builder()
                .apmType(ApmType.FUND_TRANSFER)
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .currency(Currency.TRY)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("2bc39889-b34f-40b0-abb0-4ab344360705")
                .externalId("optional-externalId")
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createApmPayment(request);
        assertNotNull(response.getId());
        assertEquals(new BigDecimal("100.00000000"), response.getPrice());
        assertEquals(PaymentStatus.SUCCESS, response.getPaymentStatus());
        assertEquals(PaymentType.APM, response.getPaymentType());
        assertEquals("2bc39889-b34f-40b0-abb0-4ab344360705", response.getConversationId());
        assertEquals(2, response.getPaymentTransactions().size());
    }

    @Test
    void retrieve_payment() {
        Long paymentId = 1L;

        PaymentResponse response = craftgate.payment().retrievePayment(paymentId);
        assertNotNull(response);
        assertEquals(paymentId, response.getId());
    }

    @Test
    void retrieve_loyalties() {
        RetrieveLoyaltiesRequest request = RetrieveLoyaltiesRequest.builder()
                .cardNumber("4043080000000003")
                .expireYear("2044")
                .expireMonth("07")
                .cvc("000")
                .build();

        RetrieveLoyaltiesResponse response = craftgate.payment().retrieveLoyalties(request);
        assertNotNull(response);
        assertEquals("Bonus", response.getCardBrand());
        assertNotNull(response.getLoyalties());
        assertTrue(response.getLoyalties().size() > 0);
        assertEquals(LoyaltyType.REWARD_MONEY, response.getLoyalties().get(0).getType());
        assertNotNull(response.getLoyalties().get(0).getReward());
        assertEquals(new BigDecimal("12.35"), response.getLoyalties().get(0).getReward().getCardRewardMoney());
        assertEquals(new BigDecimal("5.20"), response.getLoyalties().get(0).getReward().getFirmRewardMoney());
    }

    @Test
    void refund_payment() {
        RefundPaymentRequest request = RefundPaymentRequest.builder()
                .paymentId(1L)
                .refundDestinationType(RefundDestinationType.PROVIDER)
                .build();

        PaymentRefundResponse response = craftgate.payment().refundPayment(request);
        assertNotNull(response);
        assertEquals(request.getPaymentId(), response.getPaymentId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void retrieve_payment_refund() {
        Long paymentRefundId = 1L;

        PaymentRefundResponse response = craftgate.payment().retrievePaymentRefund(paymentRefundId);
        assertNotNull(response);
        assertEquals(paymentRefundId, response.getId());
    }

    @Test
    void refund_payment_transaction() {
        RefundPaymentTransactionRequest request = RefundPaymentTransactionRequest.builder()
                .paymentTransactionId(1L)
                .refundPrice(BigDecimal.valueOf(20))
                .refundDestinationType(RefundDestinationType.PROVIDER)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .build();

        PaymentTransactionRefundResponse response = craftgate.payment().refundPaymentTransaction(request);
        assertNotNull(response);
        assertEquals(request.getPaymentTransactionId(), response.getPaymentTransactionId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void retrieve_payment_transaction_refund() {
        Long paymentTransactionRefundId = 1L;

        PaymentTransactionRefundResponse response = craftgate.payment().retrievePaymentTransactionRefund(paymentTransactionRefundId);
        assertNotNull(response);
        assertEquals(paymentTransactionRefundId, response.getId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void refund_payment_transaction_mark_as_refunded() {
        RefundPaymentTransactionMarkAsRefundedRequest request = RefundPaymentTransactionMarkAsRefundedRequest.builder()
                .paymentTransactionId(1L)
                .refundPrice(BigDecimal.valueOf(20))
                .build();

        PaymentTransactionRefundResponse response = craftgate.payment().refundPaymentTransactionMarkAsRefunded(request);
        assertNotNull(response);
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void refund_payment_mark_as_refunded() {
        RefundPaymentRequest request = RefundPaymentRequest.builder()
                .paymentId(1024L)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .build();

        PaymentTransactionRefundListResponse response = craftgate.payment().refundPaymentMarkAsRefunded(request);
        assertNotNull(response);
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void store_card() {
        final StoreCardRequest storeCardRequest = StoreCardRequest.builder()
                .cardHolderName("Haluk Demir")
                .cardNumber("5258640000000001")
                .expireYear("2044")
                .expireMonth("07")
                .cardAlias("My Other Cards")
                .build();

        StoredCardResponse response = craftgate.payment().storeCard(storeCardRequest);

        assertNotNull(response);
        assertNotNull(response.getCardToken());
        assertNotNull(response.getCardUserKey());
        assertNotNull(response.getCreatedAt());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals("My Other Cards", response.getCardAlias());
        assertEquals("Haluk Demir", response.getCardHolderName());
    }

    @Test
    void update_stored_card() {
        final UpdateCardRequest updateCardRequest = UpdateCardRequest.builder()
                .cardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                .cardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                .expireYear("2044")
                .expireMonth("07")
                .build();

        StoredCardResponse response = craftgate.payment().updateCard(updateCardRequest);

        assertNotNull(response);
        assertNotNull(response.getCardToken());
        assertNotNull(response.getCardUserKey());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
    }

    @Test
    void clone_stored_card() {
        final CloneCardRequest cloneCardRequest = CloneCardRequest.builder()
                .sourceCardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                .sourceCardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                .targetMerchantId(1L)
                .build();

        StoredCardResponse response = craftgate.payment().cloneCard(cloneCardRequest);

        assertNotNull(response);
        assertNotNull(response.getCardToken());
        assertNotNull(response.getCardUserKey());
    }

    @Test
    void search_stored_cards() {
        SearchStoredCardsRequest request = SearchStoredCardsRequest.builder()
                .cardAlias("My YKB Card")
                .cardBankName("YAPI VE KREDİ BANKASI A.Ş.")
                .cardBrand("World")
                .cardAssociation(CardAssociation.MASTER_CARD)
                .cardUserKey("c115ecdf-0afc-4d83-8a1b-719c2af19cbd")
                .cardToken("d9b19d1a-243c-43dc-a498-add08162df72")
                .cardType(CardType.CREDIT_CARD)
                .build();

        StoredCardListResponse response = craftgate.payment().searchStoredCards(request);
        assertNotNull(response);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void delete_stored_card() {
        DeleteStoredCardRequest request = DeleteStoredCardRequest.builder()
                .cardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                .cardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                .build();

        craftgate.payment().deleteStoredCard(request);
    }

    @Test
    void approve_payment_transactions() {
        ApprovePaymentTransactionsRequest request = ApprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = craftgate.payment().approvePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void disapprove_payment_transactions() {
        DisapprovePaymentTransactionsRequest request = DisapprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = craftgate.payment().disapprovePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void create_pre_auth_payment() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.PRE_AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
    }

    @Test
    void post_auth_payment() {
        long paymentId = 1L;
        PostAuthPaymentRequest request = PostAuthPaymentRequest.builder()
                .paidPrice(BigDecimal.valueOf(100))
                .build();

        PaymentResponse response = craftgate.payment().postAuthPayment(paymentId, request);
        assertEquals(paymentId, response.getId());
        assertEquals(PaymentPhase.POST_AUTH, response.getPaymentPhase());
    }

    @Test
    void create_multi_currency_payment() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.USD)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5400010000000004")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(PaymentSource.API, response.getPaymentSource());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("540001", response.getBinNumber());
        assertEquals("0004", response.getLastFourDigits());
        assertNull(response.getCardType());
        assertNull(response.getCardAssociation());
        assertNull(response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
    }

    @Test
    void update_payment_transaction() {
        UpdatePaymentTransactionRequest request = UpdatePaymentTransactionRequest.builder()
                .paymentTransactionId(10L)
                .subMerchantMemberId(1L)
                .subMerchantMemberPrice(BigDecimal.TEN)
                .build();

        PaymentTransactionResponse response = craftgate.payment().updatePaymentTransaction(request);
        assertEquals(request.getSubMerchantMemberId(), response.getSubMerchantMemberId());
        assertEquals(request.getSubMerchantMemberPrice().doubleValue(), response.getSubMerchantMemberPrice().doubleValue());
    }

    @Test
    void retrieve_multi_payment() {
        String token = "6d7e66b5-9b1c-4c1d-879a-2557b651096e";

        MultiPaymentResponse response = craftgate.payment().retrieveMultiPayment(token);

        assertNotNull(response);
    }

    @Test
    void retrieve_provider_card() {

        RetrieveProviderCardRequest retrieveProviderCardRequest = RetrieveProviderCardRequest.builder()
                .providerCardToken("45f12c74-3000-465c-96dc-876850e7dd7a")
                .providerCardUserId("0309ac2d-c5a5-4b4f-a91f-5c444ba07b24")
                .externalId("1001")
                .build();

        StoredCardResponse response = craftgate.payment().retrieveProviderCard(retrieveProviderCardRequest);

        assertNotNull(response);
    }

    @Test
    void should_validate_3D_secure_callback_verified() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "1d3fa1e51fe7c350185c5a7f8c3ff513a991367b08c16a56f4ab9abeb738a1e1");
            put("paymentId", "5");
            put("conversationData", "conversation-data");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.payment().is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertTrue(isVerified);
    }

    @Test
    void should_validate_3D_secure_callback_verified_even_params_has_nullable_value() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "a097f0231031a88f2d687b510afca2505ccd2977d6421be4c3784666703f6f25");
            put("paymentId", "5");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.payment().is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertTrue(isVerified);
    }

    @Test
    void should_not_validate_3D_secure_callback_when_hashes_are_not_equal() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "39427942bcaasjaduqabzhdancaASasdhbcxjancakjscace82");
            put("paymentId", "5");
            put("conversationData", "conversation-data");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.payment().is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertFalse(isVerified);
    }
}
