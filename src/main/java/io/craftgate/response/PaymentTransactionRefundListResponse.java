package io.craftgate.response;

import io.craftgate.response.common.ListResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentTransactionRefundListResponse extends ListResponse<PaymentTransactionRefundResponse> {

}
