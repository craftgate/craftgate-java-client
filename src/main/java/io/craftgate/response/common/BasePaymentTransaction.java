package io.craftgate.response.common;

import io.craftgate.response.dto.Payout;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BasePaymentTransaction {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal subMerchantMemberPrice;
    private BigDecimal subMerchantMemberPayoutRate;
    private BigDecimal subMerchantMemberPayoutAmount;
    private LocalDateTime blockageResolvedDate;
    private Payout payout;
}
