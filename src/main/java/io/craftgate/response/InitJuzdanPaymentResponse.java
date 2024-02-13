package io.craftgate.response;

import lombok.Data;

@Data
public class InitJuzdanPaymentResponse {
    private String referenceId;
    private String juzdanQrUrl;
}