package io.craftgate.request;

import io.craftgate.model.RefundDestinationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefundPaymentRequest {

    private Long paymentId;
    private String conversationId;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.CARD;

    @Builder.Default
    private Boolean chargeFromMe = false;
}
