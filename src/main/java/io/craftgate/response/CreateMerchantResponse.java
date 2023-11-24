package io.craftgate.response;

import io.craftgate.response.dto.MerchantApiCredential;
import lombok.Data;

import java.util.List;

@Data
public class CreateMerchantResponse {

    private Long id;
    private String name;
    private List<MerchantApiCredential> merchantApiCredentials;
}
