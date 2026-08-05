package io.craftgate.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdatePaymentTransactionRequest extends BaseRequest {

    private Long paymentTransactionId;
    private Long subMerchantMemberId;
    private BigDecimal subMerchantMemberPrice;
    private LocalDateTime blockageResolvedDate;
}
