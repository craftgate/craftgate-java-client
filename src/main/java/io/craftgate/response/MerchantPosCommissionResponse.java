package io.craftgate.response;

import io.craftgate.model.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MerchantPosCommissionResponse {

    private Long id;
    private Status status;
    private Integer installment;
    private Integer blockageDay;
    private String installmentLabel;
    private String cardBrandName;
    private BigDecimal bankOnUsCreditCardCommissionRate;
    private BigDecimal bankNotOnUsCreditCardCommissionRate;
    private BigDecimal bankOnUsDebitCardCommissionRate;
    private BigDecimal bankNotOnUsDebitCardCommissionRate;
    private BigDecimal bankForeignCardCommissionRate;
    private BigDecimal merchantCommissionRate;
}