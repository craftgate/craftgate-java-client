package io.craftgate.response.dto;

import io.craftgate.model.TransactionStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentTransaction {

    private Long id;
    private String externalId;
    private String name;
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
