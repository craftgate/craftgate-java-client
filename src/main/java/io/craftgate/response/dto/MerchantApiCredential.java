package io.craftgate.response.dto;

import lombok.Data;

@Data
public class MerchantApiCredential {

    private String name;
    private String apiKey;
    private String secretKey;
}
