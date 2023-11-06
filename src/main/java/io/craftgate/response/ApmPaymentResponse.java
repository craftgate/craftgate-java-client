package io.craftgate.response;

import io.craftgate.model.ApmType;
import lombok.Data;


@Data
public class ApmPaymentResponse {

    private ApmType apmType;
    private String transactionId;
    private String redirectUrl;

}