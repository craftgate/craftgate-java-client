package io.craftgate.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdateCardRequest extends BaseRequest {

    @ToString.Exclude
    private String cardUserKey;
    @ToString.Exclude
    private String cardToken;
    @ToString.Exclude
    private String expireYear;
    @ToString.Exclude
    private String expireMonth;
    private String cardAlias;
}
