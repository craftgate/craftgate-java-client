package io.craftgate.response;

import lombok.Data;

@Data
public class MasterpassPaymentThreeDSInitResponse {

    private Long paymentId;
    private String returnUrl;
}