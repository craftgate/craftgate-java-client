package io.craftgate.response;

import io.craftgate.response.common.ListResponse;
import io.craftgate.response.dto.SettlementRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SettlementRowListResponse extends ListResponse<SettlementRow> {

}
