package io.craftgate.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class InitThreeDSPaymentRequest extends CreatePaymentRequest {

    private String callbackUrl;
}
