package io.craftgate.request;

import io.craftgate.model.AccountOwner;
import io.craftgate.model.Currency;
import io.craftgate.model.PayoutAccountType;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreatePayoutAccountRequest extends BaseRequest {

    private PayoutAccountType type;
    private String externalAccountId;
    private Currency currency;
    private AccountOwner accountOwner;
    private Long subMerchantMemberId;
}
