package io.craftgate.request.dto;

import io.craftgate.model.TokenizedCardType;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class EncryptedCard {
    private String cardData;
    private String type;
}