package io.craftgate.response.dto;

import io.craftgate.model.PayoutStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionPayoutStatus {

    private PayoutStatus merchantStatus;
    private LocalDateTime merchantStatusDate;
    private PayoutStatus subMerchantMemberStatus;
    private LocalDateTime subMerchantMemberStatusDate;

}
