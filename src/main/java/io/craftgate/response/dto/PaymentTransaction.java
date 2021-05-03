package io.craftgate.response.dto;

import io.craftgate.model.TransactionStatus;
import io.craftgate.response.common.BasePaymentTransaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentTransaction extends BasePaymentTransaction {

    private String externalId;
    private TransactionStatus transactionStatus;
    private Long subMerchantMemberId;
}
