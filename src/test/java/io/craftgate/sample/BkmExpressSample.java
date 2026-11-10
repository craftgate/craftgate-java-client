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
