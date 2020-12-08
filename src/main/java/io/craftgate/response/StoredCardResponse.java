package io.craftgate.response;

import lombok.Data;
import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardType;

@Data
public class StoredCardResponse {

    private String binNumber;
    private String lastFourDigits;
    private String expireYear;
    private String expireMonth;
    private String cardHolderName;
    private String cardUserKey;
    private String cardToken;
    private String cardAlias;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String cardBankName;
    private Long cardBankId;
}
