package io.craftgate.request;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardExpiryStatus;
import io.craftgate.model.CardType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchBankAccountTrackingRecordsRequest {

    private Currency currency;
    private String description;
    private String senderName;
    private String senderIban;
    private LocalDateTime minRecordDate;
    private LocalDateTime maxRecordDate;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
