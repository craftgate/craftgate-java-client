package io.craftgate.response.dto;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.CardType;
import io.craftgate.model.PaymentPhase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCard {

    private PaymentPhase paymentPhase;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private String cardHolderName;
    private String cardIssuerBankName;
    private String binNumber;
    private String lastFourDigits;
    private Integer installment;
    private Boolean isThreeDS;
    private Integer mdStatus;
    private String authCode;
    private String hostReference;
    private String transId;
    private Boolean paidWithStoredCard;
    private BigDecimal bankCommissionRate;
    private BigDecimal bankCommissionRateAmount;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private MerchantPos merchantPos;
    private PaymentError error;
}
