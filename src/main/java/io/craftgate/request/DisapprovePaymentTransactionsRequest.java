package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class DisapprovePaymentTransactionsRequest extends BaseRequest {

    private Set<Long> paymentTransactionIds;

    @Builder.Default
    private Boolean isTransactional = false;
}
