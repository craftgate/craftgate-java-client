package io.craftgate.request;

import io.craftgate.model.RefundDestinationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefundPaymentTransactionMarkAsRefundedRequest {

    private Long paymentTransactionRefundId;
    private String conversationId;
    private String description;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.PROVIDER;

    @Builder.Default
    private Boolean chargeFromMe = false;
}
