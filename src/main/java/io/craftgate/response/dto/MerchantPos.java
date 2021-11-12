package io.craftgate.response.dto;

import lombok.Data;

@Data
public class MerchantPos {

    private Long id;
    private String name;
    private String alias;
    private Long bankId;
}
