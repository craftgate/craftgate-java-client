package io.craftgate.response;

import io.craftgate.response.dto.PaymentTransactionApproval;
import lombok.Data;

import java.util.List;

@Data
public class PaymentTransactionApprovalListResponse {

    private Long size;
    private List<PaymentTransactionApproval> items;
}
