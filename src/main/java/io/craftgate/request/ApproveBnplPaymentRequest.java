package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class ApproveBnplPaymentRequest extends BaseRequest {

    private Long paymentId;
}
