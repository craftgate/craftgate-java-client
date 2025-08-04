package io.craftgate.response;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.PaymentStatus;
import io.craftgate.response.dto.PaymentError;
import lombok.Data;

import java.util.Map;

@Data
public class ApmPaymentInitResponse {

    private Long paymentId;
    private String redirectUrl;
    private String htmlContent;
    private PaymentStatus paymentStatus;
    private ApmAdditionalAction additionalAction;
    private PaymentError paymentError;
    private Map<String, Object> additionalData;
}