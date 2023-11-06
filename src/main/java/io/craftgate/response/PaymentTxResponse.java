package io.craftgate.response;

import io.craftgate.model.TransactionStatus;
import io.craftgate.request.dto.ConvertedPaymentTxPayout;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTxResponse {

    private Long id;
    private String externalId;
    private String name;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantPayoutAmount;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private BigDecimal subMerchantMemberPayoutRate;
    private BigDecimal subMerchantMemberPayoutAmount;
    private TransactionStatus transactionStatus;
    private LocalDateTime blockageResolvedDate;
    private ConvertedPaymentTxPayout payout;
}
