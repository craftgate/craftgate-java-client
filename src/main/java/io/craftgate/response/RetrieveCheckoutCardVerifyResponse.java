package io.craftgate.response;

import lombok.Data;

@Data
public class RetrieveCheckoutCardVerifyResponse {

    private String token;
    private StoredCardResponse card;
}
