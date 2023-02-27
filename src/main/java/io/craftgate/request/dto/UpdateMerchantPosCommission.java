package io.craftgate.request.dto;

import io.craftgate.model.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateMerchantPosCommission {

    /*
    * Supported card brand names -> "Bonus", "Axess", "Maximum", "World", "Paraf", "CardFinans", "Bankkart Combo", "Advantage", "Sağlam Kart"
    * */
    private String cardBrandName;

    private Integer installment;

    private Status status;

    private Integer blockageDay;

    private String installmentLabel;

    private BigDecimal bankOnUsCreditCardCommissionRate;

    private BigDecimal bankOnUsDebitCardCommissionRate;

    private BigDecimal bankNotOnUsCreditCardCommissionRate;

    private BigDecimal bankNotOnUsDebitCardCommissionRate;

    private BigDecimal bankForeignCardCommissionRate;

    private BigDecimal merchantCommissionRate;
}