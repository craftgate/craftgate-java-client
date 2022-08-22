package io.craftgate.response.dto;

import io.craftgate.model.FraudAction;
import io.craftgate.model.FraudCheckStatus;
import io.craftgate.model.PaymentStatus;
import io.craftgate.model.Status;
import io.craftgate.request.dto.FraudPaymentData;
import lombok.Data;

@Data
public class FraudCheck {
    private Long id;
    private Status status;
    private FraudAction action;
    private FraudCheckStatus checkStatus;
    private FraudPaymentData paymentData;
    private Long ruleId;
    private String ruleName;
    private String ruleConditions;
    private Long paymentId;
    private PaymentStatus paymentStatus;
}
