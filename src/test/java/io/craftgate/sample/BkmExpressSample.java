package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.model.PaymentProvider;
import io.craftgate.model.TokenizedCardType;
import io.craftgate.request.*;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.request.dto.TokenizedCard;
import io.craftgate.response.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BkmExpressSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void init_bkm_express() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.3))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.5))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(0.2))
                .build());

        InitBkmExpressRequest request = InitBkmExpressRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .conversationId("d1811bb0-25a2-40c7-ba71-c8b605259611")
                .currency(Currency.TRY)
                .items(items)
                .paymentPhase(PaymentPhase.AUTH)
                .build();

        InitBkmExpressResponse response = craftgate.bkmExpressPaymentAdapter().init(request);
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertNotNull(response.getPath());
        assertNotNull(response.getId());
    }

    @Test
    void complete_bkm_express() {

        CompleteBkmExpressRequest completeBkmExpressRequest = CompleteBkmExpressRequest.builder()
                .message("İşlem Başarılı")
                .status(true)
                .ticketId("dcfdc163-0545-46d7-8f86-5a11718e56ec")
                .build();

        PaymentResponse response = craftgate.bkmExpressPaymentAdapter().complete(completeBkmExpressRequest);
        assertNotNull(response);
        assertNotNull(response.getOrderId());
    }

    @Test
    void complete_bkm_express_by_token() {

        CompleteBkmExpressRequest completeBkmExpressRequest = CompleteBkmExpressRequest.builder()
                .message("İşlem Başarılı")
                .status(true)
                .ticketId("7c0f7c89-e954-46d5-ad37-2a5c0b5f0356")
                .bkmExpressPaymentToken("23f4e147-2c4e-4a2c-8a67-9c783d813b79")
                .build();

        PaymentResponse response = craftgate.bkmExpressPaymentAdapter().complete(completeBkmExpressRequest);
        assertNotNull(response);
        assertNotNull(response.getOrderId());
    }

    @Test
    void retrieve_bkm_express_payment() {

        String ticketId = "b9bd7b93-662f-4460-9ef3-8fc735853cf1";

        PaymentResponse response = craftgate.bkmExpressPaymentAdapter().retrievePayment(ticketId);
        assertNotNull(response);
    }

    @Test
    void retrieve_bkm_express_payment_by_token() {

        String bkmExpressPaymentToken = "23f4e147-2c4e-4a2c-8a67-9c783d813b79";

        PaymentResponse response = craftgate.bkmExpressPaymentAdapter().retrievePaymentByToken(bkmExpressPaymentToken);
        assertNotNull(response);
    }

    @Test
    void generate_bkm_express_token() {
        BkmExpressGenerateTokenRequest request = BkmExpressGenerateTokenRequest.builder()
                .userId("userId")
                .gsmNumber("5551111111")
                .build();

        BkmExpressGenerateTokenResponse response = craftgate.bkmExpressPaymentAdapter().generateToken(request);
        assertNotNull(response.getToken());
    }

    @Test
    void create_payment_with_bkm_express_tokenized_card() {
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

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .tokenizedCard(bkmExpressTokenizedCard())
                        .build())
                .items(items)
                .build();

        PaymentResponse response = craftgate.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(PaymentProvider.BKM_EXPRESS, response.getPaymentProvider());
    }

    @Test
    void init_3DS_payment_with_bkm_express_tokenized_card() {
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

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.ONE)
                .paidPrice(BigDecimal.ONE)
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/craftgate-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .tokenizedCard(bkmExpressTokenizedCard())
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = craftgate.payment().init3DSPayment(request);
        assertNotNull(response.getPaymentId());
        assertNotNull(response.getHtmlContent());
    }

    private TokenizedCard bkmExpressTokenizedCard() {
        // cardId is returned by the BKM Express client SDK after the buyer selects a card;
        // gsmNumber and userId must match the values sent to generateToken.
        Map<String, Object> data = new HashMap<>();
        data.put("cardId", "bkm-express-card-id");
        data.put("gsmNumber", "5551111111");
        data.put("userId", "userId");

        return TokenizedCard.builder()
                .type(TokenizedCardType.BKM_EXPRESS)
                .data(data)
                .build();
    }
}
