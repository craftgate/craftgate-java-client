package io.craftgate.request;

import io.craftgate.model.RefundDestinationType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RefundPaymentTransactionRequest extends BaseRequest {

    private Long paymentTransactionId;
    private String conversationId;
    private BigDecimal refundPrice;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.PROVIDER;

    @Builder.Default
    private Boolean chargeFromMe = false;
}
