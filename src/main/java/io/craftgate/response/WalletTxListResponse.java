package io.craftgate.response;

import io.craftgate.response.common.ListResponse;
import lombok.Data;

@Data
public class WalletTxListResponse extends ListResponse<WalletTxResponse> {
}
