package io.craftgate.request;

import io.craftgate.model.FileStatus;
import io.craftgate.model.WalletTransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SearchSettlementRowsRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
    private FileStatus fileStatus;
}
