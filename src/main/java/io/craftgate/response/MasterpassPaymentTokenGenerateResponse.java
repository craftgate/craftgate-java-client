package io.craftgate.response;

import lombok.Data;

@Data
public class MasterpassPaymentTokenGenerateResponse {

    private String token;
    private String referenceId;
    private String orderNo;
    private String terminalGroupId;
}