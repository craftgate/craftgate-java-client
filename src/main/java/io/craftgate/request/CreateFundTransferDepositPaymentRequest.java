package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateFundTransferDepositPaymentRequest {

    private BigDecimal price;
    private Long buyerMemberId;
    private String conversationId;
    private String clientIp;
}
