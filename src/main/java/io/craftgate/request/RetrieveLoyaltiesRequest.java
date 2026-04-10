package io.craftgate.request;

import io.craftgate.request.dto.FraudCheckParameters;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveLoyaltiesRequest {
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
