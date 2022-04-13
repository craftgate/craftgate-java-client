package io.craftgate.response;

import io.craftgate.model.Currency;
import io.craftgate.model.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private BigDecimal price;
    private Currency currency;
    private Integer stock;
    private Integer soldCount;
    private String token;
    private String enabledInstallments;
    private String url;
    private String imageUrl;
    private String qrCodeUrl;
    private String channel;
}
