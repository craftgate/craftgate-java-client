package io.craftgate.request;

import io.craftgate.request.dto.UpdateMerchantPosCommission;
import lombok.Data;

import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdateMerchantPosCommissionsRequest extends BaseRequest {

    private List<UpdateMerchantPosCommission> commissions;

}