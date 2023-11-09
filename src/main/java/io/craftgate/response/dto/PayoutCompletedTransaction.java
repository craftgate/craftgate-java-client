package io.craftgate.response.dto;

import io.craftgate.model.MerchantType;
import io.craftgate.model.SettlementEarningsDestination;
import io.craftgate.model.SettlementSource;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayoutCompletedTransaction {

    private Long payoutId;
    private Long transactionId;
    private String transactionType;
    private BigDecimal payoutAmount;
    private LocalDateTime payoutDate;
    private String currency;
    private Long merchantId;
    private MerchantType merchantType;
    private SettlementEarningsDestination settlementEarningsDestination;
    private SettlementSource settlementSource;
}