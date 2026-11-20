package io.craftgate.response;

import lombok.Data;
import lombok.ToString;

@Data
public class IVRCardTokenizationResponse {

    private String binNumber;
    private String lastFourDigits;
    @ToString.Exclude
    private String cardUserKey;
    @ToString.Exclude
    private String cardToken;
    private String secureFieldsToken;
}
