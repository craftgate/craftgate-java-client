package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.PayoutApprovalStatus;
import io.craftgate.response.dto.PayoutItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentTxPayoutResponse {

    private Long paymentTransactionId;
    private Currency currency;
    private BigDecimal parity;
    private PayoutApprovalStatus approvalStatus;
    private LocalDateTime approvalStatusDate;
    private LocalDateTime blockageResolvedDate;
    private LocalDateTime createdDate;
    private List<PayoutItem> payoutItems;
}
