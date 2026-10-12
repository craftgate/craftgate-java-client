package io.craftgate.request.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EncryptedCard {
    private String cardData;
    private String type;
}