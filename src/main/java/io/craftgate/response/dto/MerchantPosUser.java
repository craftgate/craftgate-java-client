package io.craftgate.response.dto;

import io.craftgate.model.PosOperationType;
import io.craftgate.model.PosUserType;
import lombok.Data;

@Data
public class MerchantPosUser {

    private Long id;
    private String posUsername;
    private String posPassword;
    private PosUserType posUserType;
    private PosOperationType posOperationType;
}
