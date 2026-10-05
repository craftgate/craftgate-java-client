package io.craftgate.request;

import io.craftgate.model.AccountOwner;
import io.craftgate.model.Currency;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPayoutAccountRequest extends BaseRequest {

    private Currency currency;
    private AccountOwner accountOwner;
    private Long subMerchantMemberId;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
