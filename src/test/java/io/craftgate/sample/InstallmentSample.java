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
        assertEquals(response.getBinNumber(), binNumber);
        assertEquals(response.getCardType(), CardType.CREDIT_CARD);
        assertEquals(response.getCardAssociation(), CardAssociation.MASTER_CARD);
        assertEquals(response.getCardBrand(), "World");
        assertEquals(response.getBankName(), "YAPI VE KREDİ BANKASI A.Ş.");
        assertEquals(response.getBankCode(), 67L);
        assertEquals(response.getCommercial(), false);
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
