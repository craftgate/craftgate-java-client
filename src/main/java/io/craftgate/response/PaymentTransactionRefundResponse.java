package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.response.common.BasePaymentTransactionRefundResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentTransactionRefundResponse extends BasePaymentTransactionRefundResponse {

    private Currency currency;
    private Long paymentId;
}
