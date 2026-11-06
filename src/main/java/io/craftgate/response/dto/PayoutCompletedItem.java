package io.craftgate.response.dto;

import io.craftgate.model.Currency;
import io.craftgate.model.MerchantType;
import io.craftgate.model.SettlementEarningsDestination;
import io.craftgate.model.SettlementRowItemSubject;
import io.craftgate.model.SettlementSource;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayoutCompletedItem {

    private Long settlementRowId;
    private Long settlementFileId;
    private SettlementRowItemSubject subject;
    private Long subjectId;
    private Long paymentTransactionId;
    private MerchantType merchantType;
    private Long merchantId;
    private BigDecimal payoutAmount;
    private Currency currency;
    private LocalDateTime payoutDate;
    private SettlementEarningsDestination settlementEarningsDestination;
    private SettlementSource settlementSource;
}
