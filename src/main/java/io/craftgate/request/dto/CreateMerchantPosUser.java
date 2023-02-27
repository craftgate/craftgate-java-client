package io.craftgate.request.dto;

import io.craftgate.model.PosOperationType;
import io.craftgate.model.PosUserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMerchantPosUser {
    private String posUsername;
    private String posPassword;
    private PosUserType posUserType;
    private PosOperationType posOperationType;
}