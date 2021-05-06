package io.craftgate.response.common;

import io.craftgate.model.TransactionStatus;
import io.craftgate.response.dto.Payout;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BasePaymentTransaction {

    private Long id;
    private String name;
    private String externalId;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal merchantPayoutAmount;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private BigDecimal subMerchantMemberPayoutRate;
    private BigDecimal subMerchantMemberPayoutAmount;
    private TransactionStatus transactionStatus;
    private LocalDateTime blockageResolvedDate;
    private Payout payout;
}
