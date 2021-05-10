package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import io.craftgate.model.TransactionPayoutStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WithdrawResponse {

    private Long id;
    private LocalDateTime createdDate;
    private Status status;
    private BigDecimal price;
    private String description;
    private Currency currency;
    private TransactionPayoutStatus payoutStatus;
    private Long memberId;
    private Long payoutId;
}