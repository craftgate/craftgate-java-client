package io.craftgate.response;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardExpiryStatus;
import io.craftgate.model.CardType;
import lombok.Data;

@Data
public class CardResponse {

    private String binNumber;
    private String lastFourDigits;
    private String cardUserKey;
    private String cardToken;
    private String cardAlias;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String cardBankName;
    private Long cardBankId;
    private CardExpiryStatus cardExpiryStatus;
}
