package io.craftgate.response;

import io.craftgate.response.common.ListResponse;
import io.craftgate.response.dto.PayoutRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PayoutRowListResponse extends ListResponse<PayoutRow> {

}
