package io.craftgate.request.dto;

import lombok.Data;

@Data
public class FraudCheckParameters {

    private String buyerExternalId;
    private String buyerGsmNumber;
    private String buyerEmail;
}
