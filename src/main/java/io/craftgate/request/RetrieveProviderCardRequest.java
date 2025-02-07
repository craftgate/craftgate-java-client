package io.craftgate.request;


import io.craftgate.model.CardProvider;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveProviderCardRequest {

    private String providerCardToken;
    private String externalId;
    private String providerCardUserId;
    private CardProvider cardProvider;
}
