package io.craftgate.response;

import io.craftgate.response.dto.BnplBankOffer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BnplPaymentOfferResponse {

    private String offerId;
    private BigDecimal price;
    private List<BnplBankOffer> bankOffers;

}