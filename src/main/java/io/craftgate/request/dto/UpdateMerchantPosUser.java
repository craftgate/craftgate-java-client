package io.craftgate.request.dto;

import io.craftgate.model.PosOperationType;
import io.craftgate.model.PosUserType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class UpdateMerchantPosUser {
    private Long id;
    @ToString.Exclude
    private String posUsername;
    @ToString.Exclude
    private String posPassword;
    private PosUserType posUserType;
    private PosOperationType posOperationType;
}