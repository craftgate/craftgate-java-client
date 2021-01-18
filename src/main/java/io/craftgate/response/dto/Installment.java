package io.craftgate.response.dto;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Installment {

    private String binNumber;
    private BigDecimal price;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String bankName;
    private Long bankCode;
    private Boolean force3ds;
    private Boolean commercial;
    private List<InstallmentPrice> installmentPrices;
}
