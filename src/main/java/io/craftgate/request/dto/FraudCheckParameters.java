package io.craftgate.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckParameters {

    private String buyerExternalId;
    private String buyerPhoneNumber;
    private String buyerEmail;
    private String customFraudVariable;
}
