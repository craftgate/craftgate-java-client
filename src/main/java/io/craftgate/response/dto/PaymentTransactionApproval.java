package io.craftgate.response.dto;

import lombok.Data;
import io.craftgate.model.ApprovalStatus;

@Data
public class PaymentTransactionApproval {

    private Long paymentTransactionId;
    private ApprovalStatus approvalStatus;
    private String failedReason;
}
