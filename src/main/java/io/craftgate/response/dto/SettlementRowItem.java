package io.craftgate.response.dto;

import io.craftgate.model.SettlementRowItemSubject;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SettlementRowItem {

    private SettlementRowItemSubject subject;
    private Long subjectId;
    private Long paymentTransactionId;
    private BigDecimal payoutAmount;
}
