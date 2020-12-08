package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private String cardAlias;
    private String cardUserKey;
    private String cardToken;

    @Builder.Default
    private Boolean storeCardAfterSuccessPayment = false;
}
