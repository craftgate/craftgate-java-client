package io.craftgate.response.dto;

import io.craftgate.model.Currency;
import io.craftgate.model.MerchantType;
import io.craftgate.model.PayoutItemSubject;
import io.craftgate.model.TransactionPayoutStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayoutItem {

    private PayoutItemSubject subject;
    private Long subjectId;
    private MerchantType merchantType;
    private Long merchantId;
    private BigDecimal payoutAmount;
    private Currency currency;
    private TransactionPayoutStatus payoutStatus;
    private LocalDateTime payoutDate;
    private LocalDateTime createdDate;
}
