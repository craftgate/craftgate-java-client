package io.craftgate.request;

import io.craftgate.model.PayoutAccountType;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UpdatePayoutAccountRequest {

    private PayoutAccountType type;
    private String externalAccountId;
}
