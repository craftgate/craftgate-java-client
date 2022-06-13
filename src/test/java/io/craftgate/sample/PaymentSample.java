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

        Map<String, Map<String, Object>> additionalParams = new HashMap<>();
        Map<String, Object> paymentProviderParams = new HashMap<String, Object>() {{
            put("cardUserKey", "test-cardUserKey");
            put("cardToken", "tuz8imxv30");
        }};
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
    }

    @Test
    void retrieve_checkout_payment() {
        String token = "456d1297-908e-4bd6-a13b-4be31a6e47d5";

        PaymentResponse response = craftgate.payment().retrieveCheckoutPayment(token);

        assertNotNull(response);
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

        craftgate.payment().createFundTransferDepositPayment(request);
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
                .build();

        InitGarantiPayPaymentResponse response = craftgate.payment().initGarantiPayPayment(request);

        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
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
                .apmUserIdentity("5545510009")
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
                .refundDestinationType(RefundDestinationType.CARD)
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
                .refundDestinationType(RefundDestinationType.CARD)
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
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals("My Other Cards", response.getCardAlias());
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
    void check_masterpass_user() {
        CheckMasterpassUserRequest request = CheckMasterpassUserRequest.builder()
                .masterpassGsmNumber("903000000000")
                .build();

        CheckMasterpassUserResponse response = craftgate.payment().checkMasterpassUser(request);
        assertNotNull(response);
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
        assertEquals(null, response.getCardType());
        assertEquals(null, response.getCardAssociation());
        assertEquals(null, response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
        assertNull(response.getPaymentError());
    }
}
