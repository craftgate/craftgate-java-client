package io.craftgate.request;

import io.craftgate.model.AccountOwner;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class SearchPayoutAccountRequest {

    private Currency currency;
    private AccountOwner accountOwner;
    private Long subMerchantMemberId;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
