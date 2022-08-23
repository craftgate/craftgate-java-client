package io.craftgate.response;

import io.craftgate.response.common.ListResponse;
import io.craftgate.response.dto.FraudCheck;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FraudCheckListResponse extends ListResponse<FraudCheck> {
}
