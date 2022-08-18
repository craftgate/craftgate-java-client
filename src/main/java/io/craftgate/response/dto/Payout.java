package io.craftgate.response.dto;

import io.craftgate.model.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payout {

    private Currency currency;
    private BigDecimal parity;
    private BigDecimal paidPrice;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal subMerchantMemberPayoutAmount;
}
