package io.craftgate.request;

import lombok.*;

@Data
@Builder
public class CompleteBkmExpressRequest {

    private boolean status;
    private String message;
    private String ticketId;
    private String bkmExpressPaymentToken;
}
