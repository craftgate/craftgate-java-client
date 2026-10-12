package io.craftgate.response;

import lombok.Data;

@Data
public class IVRCardTokenizationResponse {

    private String binNumber;
    private String lastFourDigits;
    private String cardUserKey;
    private String cardToken;
    private String secureFieldsToken;
}
