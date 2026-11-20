package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class VerifyCard {
    private String cardHolderName;
    @ToString.Exclude
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    @ToString.Exclude
    private String cvc;
    private String cardAlias;
    private String cardUserKey;
}
