package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardType;
import io.craftgate.model.Currency;
import io.craftgate.request.SearchInstallmentsRequest;
import io.craftgate.response.BinNumberResponse;
import io.craftgate.response.InstallmentListResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstallmentSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_bin() {
        String binNumber = "525864";

        BinNumberResponse response = craftgate.installment().retrieveBinNumber(binNumber);
        assertEquals(binNumber, response.getBinNumber());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals("YAPI VE KREDİ BANKASI A.Ş.", response.getBankName());
        assertEquals(67L, response.getBankCode());
        assertEquals(false, response.getCommercial());
    }

    @Test
    void search_installments() {
        SearchInstallmentsRequest request = SearchInstallmentsRequest.builder()
                .binNumber("525864")
                .price(BigDecimal.valueOf(100L))
                .currency(Currency.TRY)
                .build();

        InstallmentListResponse response = craftgate.installment().searchInstallments(request);
        assertTrue(response.getItems().size() > 0);
    }
}
