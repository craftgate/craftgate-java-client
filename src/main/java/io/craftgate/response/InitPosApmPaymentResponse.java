package io.craftgate.response;

import io.craftgate.model.AdditionalAction;
import io.craftgate.model.PaymentStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

@Data
public class InitPosApmPaymentResponse {

    private String htmlContent;
    private Long paymentId;
    private PaymentStatus paymentStatus;
    private AdditionalAction additionalAction;
    private PaymentError paymentError;
}