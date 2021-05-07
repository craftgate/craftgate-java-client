package io.craftgate.response.dto;

import io.craftgate.model.PaymentRefundStatus;
import io.craftgate.response.MemberResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportingPaymentTransaction extends PaymentTransaction {

    private LocalDateTime createdDate;
    private LocalDateTime transactionStatusDate;
    private BigDecimal refundablePrice;
    private MemberResponse subMerchantMember;
    private PaymentRefundStatus refundStatus;
    private PayoutStatus payoutStatus;
    private BigDecimal bankCommissionRate;
    private BigDecimal bankCommissionRateAmount;
}
