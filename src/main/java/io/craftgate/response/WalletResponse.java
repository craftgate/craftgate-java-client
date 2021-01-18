package io.craftgate.response;

import io.craftgate.model.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private BigDecimal amount;
    private Currency currency;
    private Long memberId;
}
