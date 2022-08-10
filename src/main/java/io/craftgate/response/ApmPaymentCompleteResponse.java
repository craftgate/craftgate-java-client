package io.craftgate.response;

import io.craftgate.model.PaymentStatus;
import lombok.Data;

@Data
public class ApmPaymentCompleteResponse {

    private Long paymentId;
    private PaymentStatus status;
}