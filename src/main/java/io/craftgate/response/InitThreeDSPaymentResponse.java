package io.craftgate.response;

import lombok.Data;
import org.apache.commons.codec.binary.Base64;

@Data
public class InitThreeDSPaymentResponse {

    private String htmlContent;
    private Long paymentId;

    public String getDecodedHtmlContent() {
        return new String(Base64.decodeBase64(htmlContent));
    }
}
