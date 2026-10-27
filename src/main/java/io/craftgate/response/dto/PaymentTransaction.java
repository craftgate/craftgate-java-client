package io.craftgate.response.dto;

import io.craftgate.model.TransactionStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTransaction {

    private Long id;
    private String name;
    private String externalId;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private TransactionStatus transactionStatus;
    private LocalDateTime blockageResolvedDate;
}
