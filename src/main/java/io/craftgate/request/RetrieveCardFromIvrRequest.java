package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveCardFromIvrRequest extends BaseRequest {

    private String callToken;
    private String cardUserKey;
}
