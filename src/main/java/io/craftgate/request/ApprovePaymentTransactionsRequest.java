package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ApprovePaymentTransactionsRequest {

    private Set<Long> paymentTransactionIds;

    @Builder.Default
    private Boolean isTransactional = false;
}
