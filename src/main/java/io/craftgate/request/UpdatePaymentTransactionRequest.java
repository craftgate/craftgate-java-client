package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class UpdatePaymentTransactionRequest {

    private Long paymentTransactionId;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private LocalDateTime blockageResolvedDate;
}
