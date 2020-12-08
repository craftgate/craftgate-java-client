package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteStoredCardRequest {

    private String cardUserKey;
    private String cardToken;
}
