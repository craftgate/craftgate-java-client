package io.craftgate.response;

import io.craftgate.model.PaymentRefundStatus;
import io.craftgate.response.common.BasePaymentResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportingPaymentResponse extends BasePaymentResponse {

    private Integer retryCount;
    private BigDecimal refundablePrice;
    private PaymentRefundStatus refundStatus;
    private MemberResponse buyerMember;
    private List<ReportingPaymentRefundResponse> refunds;
}
