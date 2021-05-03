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

    private String externalId;
    private Integer retryCount;
    private BigDecimal refundablePrice;
    private PaymentRefundStatus refundStatus;
    private String cardHolderName;
    private String cardIssuerBankName;
    private Integer mdStatus;
    private BigDecimal bankCommissionRate;
    private BigDecimal bankCommissionRateAmount;
    private List<ReportingPaymentRefundResponse> refunds;
}
