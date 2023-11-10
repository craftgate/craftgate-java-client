package io.craftgate.request.dto;

import io.craftgate.model.BnplCardItemType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BnplPaymentCartItem {

    private String id;
    private String name;
    private String brandName;
    private BnplCardItemType type;
    private BigDecimal unitPrice;
    private Integer quantity;
}