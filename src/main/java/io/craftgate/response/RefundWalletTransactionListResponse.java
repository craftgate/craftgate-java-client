package io.craftgate.response;

import lombok.Data;

import java.util.List;

@Data
public class RefundWalletTransactionListResponse {

    private List<RefundWalletTransactionResponse> items;
}