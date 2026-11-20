package io.craftgate.request;

import io.craftgate.model.LoyaltyType;
import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.dto.FraudCheckParameters;
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveLoyaltiesRequest extends BaseRequest {
    @ToString.Exclude
    private String cardNumber;
    @ToString.Exclude
    private String expireYear;
    @ToString.Exclude
    private String expireMonth;
    @ToString.Exclude
    private String cvc;
    @ToString.Exclude
    private String cardUserKey;
    @ToString.Exclude
    private String cardToken;
    private String secureFieldsToken;
    private Integer installment;
    private LoyaltyType loyaltyType;
    private String clientIp;
    private Integer clientPort;
    private String conversationId;
    private FraudCheckParameters fraudParams;
}
