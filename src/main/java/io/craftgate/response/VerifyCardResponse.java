package io.craftgate.response;

import io.craftgate.model.CardVerifyStatus;
import io.craftgate.model.RefundStatus;
import lombok.Data;

@Data
public class VerifyCardResponse {


    private String cardUserKey;
    private String cardToken;
    private String htmlContent;
    private String redirectUrl;
    private String merchantCallbackUrl;
    private RefundStatus refundStatus;
    private CardVerifyStatus cardVerifyStatus;


}
