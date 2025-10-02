package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentItem {

    private String name;
    private BigDecimal price;
    private String externalId;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private Integer blockageDay;
}
