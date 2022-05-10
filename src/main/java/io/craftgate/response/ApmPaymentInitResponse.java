package io.craftgate.response;

import lombok.Data;

@Data
public class ApmPaymentInitResponse {

    private Long paymentId;
    private String redirectUrl;

}