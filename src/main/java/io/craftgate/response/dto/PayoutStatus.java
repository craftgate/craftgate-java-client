package io.craftgate.response.dto;

import io.craftgate.model.TransactionPayoutStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PayoutStatus {

    private TransactionPayoutStatus merchantStatus;
    private LocalDateTime merchantStatusDate;
    private TransactionPayoutStatus subMerchantMemberStatus;
    private LocalDateTime subMerchantMemberStatusDate;
}
