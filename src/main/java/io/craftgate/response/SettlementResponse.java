package io.craftgate.response;

import io.craftgate.model.*;
import io.craftgate.response.dto.MerchantPos;
import io.craftgate.response.dto.PaymentError;
import io.craftgate.response.dto.PaymentTransaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SettlementResponse {

    private SettlementResultStatus settlementResultStatus;
}
