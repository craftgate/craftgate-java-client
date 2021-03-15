package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.PayoutStatus;
import io.craftgate.model.Status;
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
    private PayoutStatus payoutStatus;
    private Long memberId;
}