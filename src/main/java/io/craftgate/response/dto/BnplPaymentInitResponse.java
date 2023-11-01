package io.craftgate.response.dto;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BnplPaymentInitResponse {

    private Long paymentId;
    private String redirectUrl;
    private PaymentStatus paymentStatus;
    private ApmAdditionalAction additionalAction;
    private PaymentError paymentError;

}