package io.craftgate.response;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

@Data
public class ApmPaymentInitResponse {

    private Long paymentId;
    private String redirectUrl;
    private PaymentStatus paymentStatus;
    private ApmAdditionalAction additionalAction;
}