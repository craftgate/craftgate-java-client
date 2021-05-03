package io.craftgate.response;

import io.craftgate.model.PaymentType;
import io.craftgate.response.common.BasePaymentRefundResponse;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportingPaymentRefundResponse extends BasePaymentRefundResponse {

    private PaymentType paymentType;
    private PaymentError error;
}
