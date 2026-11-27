package io.craftgate.response;

import io.craftgate.model.BounceStatus;
import io.craftgate.model.Currency;
import io.craftgate.model.MerchantType;
import io.craftgate.model.SettlementEarningsDestination;
import io.craftgate.model.SettlementSource;
import io.craftgate.response.dto.SettlementRowItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SettlementRowResponse {

    private String rowDescription;
    private LocalDateTime payoutDate;
    private String name;
    private String iban;
    private BigDecimal payoutAmount;
    private Currency currency;
    private MerchantType merchantType;
    private Long merchantId;
    private SettlementEarningsDestination settlementEarningsDestination;
    private SettlementSource settlementSource;
    private BounceStatus bounceStatus;
    private List<SettlementRowItem> items;
}
