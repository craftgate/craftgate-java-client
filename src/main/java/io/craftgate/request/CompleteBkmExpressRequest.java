package io.craftgate.request;

import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CompleteBkmExpressRequest extends BaseRequest {

    private boolean status;
    private String message;
    private String ticketId;
    private String bkmExpressPaymentToken;
}
