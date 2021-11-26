package io.craftgate.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Reward {
    private BigDecimal cardRewardMoney;
    private BigDecimal firmRewardMoney;
}
