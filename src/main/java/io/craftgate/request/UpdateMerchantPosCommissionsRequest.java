package io.craftgate.request;

import io.craftgate.request.dto.UpdateMerchantPosCommission;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateMerchantPosCommissionsRequest {

    private List<UpdateMerchantPosCommission> commissions;

}