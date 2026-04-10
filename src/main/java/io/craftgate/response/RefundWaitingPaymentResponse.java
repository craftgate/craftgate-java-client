package io.craftgate.response;

import io.craftgate.model.RefundStatus;
import lombok.Data;

@Data
public class RefundWaitingPaymentResponse {

    private RefundStatus status;
}
