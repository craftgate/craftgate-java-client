package io.craftgate.response.dto;

import io.craftgate.model.FileStatus;
import io.craftgate.model.MerchantType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SettlementRow {

    private Long id;
    private Long merchantId;
    private MerchantType merchantType;
    private BigDecimal payoutAmount;
    private FileStatus fileStatus;
}
