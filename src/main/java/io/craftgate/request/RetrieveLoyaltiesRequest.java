package io.craftgate.request;

import io.craftgate.model.LoyaltyType;
import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.dto.FraudCheckParameters;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

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
    private Integer installment;
    private LoyaltyType loyaltyType;
    private String clientIp;
    private String conversationId;
    private FraudCheckParameters fraudParams;
}
