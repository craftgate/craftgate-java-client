package io.craftgate.request;

import io.craftgate.model.AccountOwner;
import io.craftgate.model.Currency;
import io.craftgate.model.PayoutAccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePayoutAccountRequest {

    private PayoutAccountType type;
    private String externalAccountId;
    private Currency currency;
    private AccountOwner accountOwner;
    private Long subMerchantMemberId;
}
