package io.craftgate.request.dto;

import lombok.Data;

@Data
public class FraudCheckParameters {

    private String buyerExternalId;
    private String buyerPhoneNumber;
    private String buyerEmail;
}
