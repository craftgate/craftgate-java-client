package io.craftgate.request;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardExpiryStatus;
import io.craftgate.model.CardType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchStoredCardsRequest {

    private String cardAlias;
    private String cardBrand;
    private CardType cardType;
    private String cardUserKey;
    private String cardToken;
    private String cardBankName;
    private CardAssociation cardAssociation;
    private CardExpiryStatus cardExpiryStatus;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
