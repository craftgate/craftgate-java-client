package io.craftgate.request;

import io.craftgate.model.Currency;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchMerchantPosRequest extends BaseRequest {
    private String name;
    private String alias;
    private Currency currency;
    private Boolean enableInstallment;
    private Boolean enableForeignCard;
    private String bankName;
    private Integer page;
    private Integer size;

}