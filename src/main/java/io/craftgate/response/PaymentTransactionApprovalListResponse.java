package io.craftgate.response;

import lombok.Data;
import io.craftgate.response.dto.PaymentTransactionApproval;

import java.util.List;

@Data
public class PaymentTransactionApprovalListResponse {

    private Long size;
    private List<PaymentTransactionApproval> items;
}
