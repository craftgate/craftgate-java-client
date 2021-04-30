package io.craftgate.response.dto;

import io.craftgate.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionPayout {

    private BigDecimal paidPrice;
    private Currency currency;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal subMerchantMemberPayoutAmount;
    private BigDecimal parity;
    private BigDecimal bankCommissionRateAmount;

}
