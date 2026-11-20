package io.craftgate.response.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class MerchantApiCredential {

    private String name;
    private String apiKey;
    @ToString.Exclude
    private String secretKey;
}
