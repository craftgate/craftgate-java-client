package io.craftgate.response;

import io.craftgate.model.PaymentType;
import io.craftgate.response.common.BasePaymentTransactionRefundResponse;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportingSearchPaymentTransactionRefundResponse extends BasePaymentTransactionRefundResponse {

    private PaymentType paymentType;
    private PaymentError error;
    private ReportingPaymentResponse payment;
}
