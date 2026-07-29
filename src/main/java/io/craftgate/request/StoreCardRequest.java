package io.craftgate.request;

import io.craftgate.request.dto.EncryptedCard;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class StoreCardRequest extends BaseRequest {

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String secureFieldsToken;
    private String cardAlias;
    private String cardUserKey;
    private EncryptedCard encryptedCard;
}
