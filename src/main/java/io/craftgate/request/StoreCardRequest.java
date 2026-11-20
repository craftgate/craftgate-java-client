package io.craftgate.request;

import io.craftgate.request.dto.EncryptedCard;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class StoreCardRequest extends BaseRequest {

    @ToString.Exclude
    private String cardHolderName;
    @ToString.Exclude
    private String cardNumber;
    @ToString.Exclude
    private String expireYear;
    @ToString.Exclude
    private String expireMonth;
    private String secureFieldsToken;
    private String cardAlias;
    @ToString.Exclude
    private String cardUserKey;
    @ToString.Exclude
    private EncryptedCard encryptedCard;
}
