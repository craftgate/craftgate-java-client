package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdateCardRequest extends BaseRequest {

    private String cardUserKey;
    private String cardToken;
    private String expireYear;
    private String expireMonth;
    private String cardAlias;
}
