package io.craftgate.request.dto;

import io.craftgate.model.ApmType;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class BnplPaymentInitRequest {

    private String bankCode;

    private List<BnplPaymentCartItem> items;

}
