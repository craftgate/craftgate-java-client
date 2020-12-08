package io.craftgate.request;

import io.craftgate.model.RefundDestinationType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RefundPaymentTransactionRequest {

    private Long paymentTransactionId;
    private String conversationId;
    private BigDecimal refundPrice;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.CARD;
    @Builder.Default
    private Boolean chargeFromMe = false;
}
