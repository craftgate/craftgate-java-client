package io.craftgate.request;

import io.craftgate.request.dto.FraudCheckParameters;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveLoyaltiesRequest extends BaseRequest {
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;

    private String cardUserKey;
    private String cardToken;

    private String clientIp;
    private String conversationId;
    private FraudCheckParameters fraudParams;
}
