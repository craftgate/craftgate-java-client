package io.craftgate.request;


import io.craftgate.model.CardProvider;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveProviderCardRequest extends BaseRequest {

    private String providerCardToken;
    private String externalId;
    private String providerCardUserId;
    private CardProvider cardProvider;
}
