package io.craftgate.request;

import io.craftgate.request.common.BaseRequest;
import io.craftgate.model.PosStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class UpdateMerchantPosStatusRequest extends BaseRequest {

    private Long merchantPosId;
    private PosStatus posStatus;
}
