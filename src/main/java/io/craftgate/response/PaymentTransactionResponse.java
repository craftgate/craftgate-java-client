package io.craftgate.response;

import io.craftgate.model.PaymentRefundStatus;
import io.craftgate.model.TransactionStatus;
import io.craftgate.response.dto.Member;
import io.craftgate.response.dto.PaymentTransactionCard;
import io.craftgate.response.dto.PaymentTransactionPayout;
import io.craftgate.response.dto.PaymentTransactionPayoutStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTransactionResponse {

    private Long id;
    private LocalDateTime createdDate;
    private String itemName;
    private String externalId;
    private TransactionStatus transactionStatus;
    private LocalDateTime transactionStatusDate;
    private LocalDateTime blockageResolvedDate;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal refundablePrice;
    private BigDecimal merchantPayoutAmount;
    private Member subMerchantMember;
    private BigDecimal subMerchantMemberPrice;
    private BigDecimal subMerchantMemberPayoutRate;
    private BigDecimal subMerchantMemberPayoutAmount;
    private PaymentRefundStatus refundStatus;
    private PaymentTransactionPayout payout;
    private PaymentTransactionPayoutStatus payoutStatus;
    private PaymentTransactionCard paymentTxCard;
}
