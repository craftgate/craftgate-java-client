package io.craftgate.response;

import io.craftgate.model.SettlementResultStatus;
import lombok.Data;

@Data
public class SettlementResponse {

    private SettlementResultStatus settlementResultStatus;
}
