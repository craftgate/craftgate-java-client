package io.craftgate.response;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

import java.util.Map;

@Data
public class BnplLimitInquiryResponse {

    private PaymentStatus paymentStatus;
    private ApmAdditionalAction additionalAction;
    private Map<String, Object> additionalData;
    private String errorCode;
    private String errorMessage;
}