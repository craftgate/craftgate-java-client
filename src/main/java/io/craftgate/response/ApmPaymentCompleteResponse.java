package io.craftgate.response;

import io.craftgate.model.PaymentStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

@Data
public class ApmPaymentCompleteResponse {

    private Long paymentId;
    private PaymentStatus paymentStatus;
    private PaymentError paymentError;
}