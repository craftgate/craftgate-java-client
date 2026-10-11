package io.craftgate.request;

import lombok.Data;

import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateFundTransferDepositPaymentRequest extends BaseRequest {

    private BigDecimal price;
    private Long buyerMemberId;
    private String conversationId;
    private String clientIp;
    private Integer clientPort;
}
