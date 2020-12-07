package io.craftgate.response;

import lombok.Data;
import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardType;

@Data
public class BinNumberResponse {

    private String binNumber;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String bankName;
    private Long bankCode;
    private Boolean commercial;
}
