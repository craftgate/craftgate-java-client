package io.craftgate.response;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardExpiryStatus;
import io.craftgate.model.CardType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoredCardResponse {

    private String binNumber;
    private String lastFourDigits;
    private String cardUserKey;
    private String cardToken;
    private String cardHolderName;
    private String cardAlias;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String cardBankName;
    private Long cardBankId;
    private String expireYear;
    private String expireMonth;
    private Boolean isCommercial;
    private CardExpiryStatus cardExpiryStatus;
    private LocalDateTime createdAt;
}
