package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PaymentGroup;
import io.craftgate.model.PaymentPhase;
import io.craftgate.request.dto.PaymentItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class BkmExpressGenerateTokenRequest {

    private String gsmNumber;
    private String userId;
}
