package io.craftgate.response;

import io.craftgate.model.AccountOwner;
import io.craftgate.model.PayoutAccountType;
import lombok.Data;

import java.util.Currency;

@Data
public class PayoutAccountResponse {
    private Long id;
    private PayoutAccountType type;
    private String externalAccountId;
    private Currency currency;
    private AccountOwner accountOwner;
    private Long subMerchantMemberId;
}
