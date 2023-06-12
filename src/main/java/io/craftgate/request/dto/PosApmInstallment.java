package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PosApmInstallment {

    private int number;
    private BigDecimal totalPrice;
}
