package io.craftgate.request.dto;

import io.craftgate.model.Loyalty;
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
    private String binNumber;
    private String lastFourDigits;
    private String cardHolderIdentityNumber;
    private Loyalty loyalty;
    private TokenizedCard tokenizedCard;

    @Builder.Default
    private Boolean storeCardAfterSuccessPayment = false;
}
