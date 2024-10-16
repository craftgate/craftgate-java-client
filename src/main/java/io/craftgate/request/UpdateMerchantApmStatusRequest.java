package io.craftgate.request;

import io.craftgate.model.ApmStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateMerchantApmStatusRequest {
    private ApmStatus status;
}