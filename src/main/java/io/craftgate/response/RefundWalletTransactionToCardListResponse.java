package io.craftgate.response;

import lombok.Data;

import java.util.List;

@Data
public class RefundWalletTransactionToCardListResponse {

    private List<RefundWalletTransactionToCardResponse> items;
}