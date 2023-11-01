package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ApmType;
import io.craftgate.model.BnplCartItemType;
import io.craftgate.model.Currency;
import io.craftgate.request.BnplPaymentOfferRequest;
import io.craftgate.request.dto.BnplPaymentCartItem;
import io.craftgate.response.BnplPaymentOfferResponse;
import io.craftgate.response.dto.BnplBankOffer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BnplPaymentSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_bank_offer() {
        List<BnplPaymentCartItem> items = new ArrayList<>();

        items.add(BnplPaymentCartItem.builder()
                .id(UUID.randomUUID().toString())
                .name("item 1")
                .brandName("Elma")
                .type(BnplCartItemType.MOBILE_PHONE_BELOW_5000_TRY)
                .unitPrice(BigDecimal.valueOf(3000))
                .quantity(2)
                .build());
        items.add(BnplPaymentCartItem.builder()
                .id(UUID.randomUUID().toString())
                .name("item 2")
                .brandName("Elma")
                .type(BnplCartItemType.OTHER)
                .unitPrice(BigDecimal.valueOf(4000))
                .quantity(1)
                .build());

        BnplPaymentOfferRequest request = BnplPaymentOfferRequest.builder()
                .apmType(ApmType.MASLAK)
                .price(BigDecimal.valueOf(10000))
                .currency(Currency.TRY)
                .items(items)
                .build();

        BnplPaymentOfferResponse response = craftgate.bnplPayment().offer(request);
        assertNotNull(response.getOfferId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(3, response.getBankOffers().size());

        BnplBankOffer bnplBankOffer = response.getBankOffers().get(0);
        assertNotNull(bnplBankOffer);
        assertEquals(1, bnplBankOffer.getBankOfferTerms().size());
    }
}
