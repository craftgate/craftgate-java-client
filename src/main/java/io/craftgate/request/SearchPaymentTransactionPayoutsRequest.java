package io.craftgate.request;

import lombok.Data;

import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPaymentTransactionPayoutsRequest extends BaseRequest {

    private Set<Long> paymentTransactionIds;
}
