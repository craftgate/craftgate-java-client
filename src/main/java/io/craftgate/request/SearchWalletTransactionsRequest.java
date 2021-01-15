package io.craftgate.request;

import io.craftgate.model.WalletTransactionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchWalletTransactionsRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
    private WalletTransactionType walletTransactionType;

}
