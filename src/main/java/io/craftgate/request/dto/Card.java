package io.craftgate.request.dto;

import io.craftgate.model.Loyalty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class Card {

    @ToString.Exclude
    private String cardHolderName;
    @ToString.Exclude
    private String cardNumber;
    @ToString.Exclude
    private String expireYear;
    @ToString.Exclude
    private String expireMonth;
    @ToString.Exclude
    private String cvc;
    private String cardAlias;
    @ToString.Exclude
    private String cardUserKey;
    private String secureFieldsToken;
    @ToString.Exclude
    private String cardToken;
    private String binNumber;
    private String lastFourDigits;
    private String cardHolderIdentityNumber;
    private Loyalty loyalty;
    private TokenizedCard tokenizedCard;
    @ToString.Exclude
    private EncryptedCard encryptedCard;

    @Builder.Default
    private Boolean storeCardAfterSuccessPayment = false;
}
