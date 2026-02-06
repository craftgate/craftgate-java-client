package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreCardRequest {

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String secureFieldsToken;
    private String cardAlias;
    private String cardUserKey;
}
