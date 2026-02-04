package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyCardDto {
    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private String cardAlias;
    private String cardUserKey;
}
