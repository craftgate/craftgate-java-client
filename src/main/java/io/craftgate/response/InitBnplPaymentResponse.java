package io.craftgate.response;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.PaymentStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

@Data
public class InitBnplPaymentResponse {

    private Long paymentId;
    private String redirectUrl;
    private PaymentStatus paymentStatus;
    private ApmAdditionalAction additionalAction;
    private PaymentError paymentError;
}