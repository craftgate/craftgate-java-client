package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class InitThreeDSPaymentRequest extends CreatePaymentRequest {

    private String callbackUrl;
}
