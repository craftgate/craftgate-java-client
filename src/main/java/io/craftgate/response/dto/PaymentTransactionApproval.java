package io.craftgate.response.dto;

import io.craftgate.model.ApprovalStatus;
import lombok.Data;

@Data
public class PaymentTransactionApproval {

    private Long paymentTransactionId;
    private ApprovalStatus approvalStatus;
    private String failedReason;
}
