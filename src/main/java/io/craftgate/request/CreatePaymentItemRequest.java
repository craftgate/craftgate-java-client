package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreatePaymentItemRequest {

    private String externalId;
    private String name;
    private BigDecimal price;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
}
