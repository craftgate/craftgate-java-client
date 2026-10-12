package io.craftgate.request;

import io.craftgate.model.RefundDestinationType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RefundPaymentRequest extends BaseRequest {

    private Long paymentId;
    private String conversationId;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.PROVIDER;

    @Builder.Default
    private Boolean chargeFromMe = false;
}
