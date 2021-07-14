package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCardRequest {

    private String cardUserKey;
    private String cardToken;
    private String expireYear;
    private String expireMonth;
}
