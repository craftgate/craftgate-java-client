package io.craftgate.request.dto;

import io.craftgate.model.Loyalty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class Card {

    private String cardHolderName;
    @ToString.Exclude
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    @ToString.Exclude
    private String cvc;
    private String cardAlias;
    private String cardUserKey;
    private String secureFieldsToken;
    private String cardToken;
    private String binNumber;
    private String lastFourDigits;
    private String cardHolderIdentityNumber;
    private Loyalty loyalty;
    private TokenizedCard tokenizedCard;
    private EncryptedCard encryptedCard;

    @Builder.Default
    private Boolean storeCardAfterSuccessPayment = false;
}
