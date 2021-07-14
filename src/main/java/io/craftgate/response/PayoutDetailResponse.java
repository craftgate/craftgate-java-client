package io.craftgate.response;

import io.craftgate.model.BounceStatus;
import io.craftgate.response.dto.PayoutDetailTransaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PayoutDetailResponse {

    private String rowDescription;
    private LocalDateTime payoutDate;
    private String name;
    private String iban;
    private BigDecimal payoutAmount;
    private String currency;
    private Long merchantId;
    private String merchantType;
    private String settlementEarningsDestination;
    private String settlementSource;
    private BounceStatus bounceStatus;
    private List<PayoutDetailTransaction> payoutTransactions;
}
