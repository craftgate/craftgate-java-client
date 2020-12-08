package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPaymentTransactionRefundsRequest {

    private Long paymentId;
    private String conversationId;
    private Long paymentTransactionId;
}
