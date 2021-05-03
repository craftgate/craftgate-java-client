package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.RefundType;
import io.craftgate.response.common.BasePaymentRefundResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentRefundResponse extends BasePaymentRefundResponse {

    private RefundType refundType;
    private Currency currency;
    private Long paymentId;
    private List<PaymentTransactionRefundResponse> paymentTransactionRefunds;
}
