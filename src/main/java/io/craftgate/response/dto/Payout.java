package io.craftgate.response.dto;

import lombok.Builder;
import lombok.Data;
import io.craftgate.model.Currency;

import java.math.BigDecimal;

@Data
@Builder
public class Payout {

    private BigDecimal paidPrice;
    private Currency currency;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal subMerchantMemberPayoutAmount;
}
