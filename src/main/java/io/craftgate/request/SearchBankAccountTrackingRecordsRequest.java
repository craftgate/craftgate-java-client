package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchBankAccountTrackingRecordsRequest extends BaseRequest {

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
