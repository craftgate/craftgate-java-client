package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class VerifyCard {
    @ToString.Exclude
    private String cardHolderName;
    @ToString.Exclude
    private String cardNumber;
    @ToString.Exclude
    private String expireYear;
    @ToString.Exclude
    private String expireMonth;
    @ToString.Exclude
    private String cvc;
    private String cardAlias;
    @ToString.Exclude
    private String cardUserKey;
}
