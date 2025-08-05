package io.craftgate.response;

import io.craftgate.model.AdditionalAction;
import io.craftgate.model.PaymentStatus;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;

@Data
public class InitThreeDSPaymentResponse {

    private String htmlContent;
    private Long paymentId;
    private String redirectUrl;
    private PaymentStatus paymentStatus;
    private AdditionalAction additionalAction;

    public String getDecodedHtmlContent() {
        return new String(Base64.decodeBase64(htmlContent));
    }
}
