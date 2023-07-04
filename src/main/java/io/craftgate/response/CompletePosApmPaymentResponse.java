package io.craftgate.response;

import io.craftgate.model.PaymentStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

@Data
public class CompletePosApmPaymentResponse {

    private String conversationId;
    private Long paymentId;
    private PaymentStatus paymentStatus;
    private PaymentError paymentError;
}