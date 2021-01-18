package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.RemittanceReasonType;
import io.craftgate.model.RemittanceType;
import io.craftgate.request.CreateRemittanceRequest;
import io.craftgate.request.SearchWalletTransactionsRequest;
import io.craftgate.request.SearchWalletsRequest;
import io.craftgate.response.RemittanceResponse;
import io.craftgate.response.WalletListResponse;
import io.craftgate.response.WalletTransactionListResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WalletSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_wallets() {
        SearchWalletsRequest request = SearchWalletsRequest.builder()
                .memberId(1L)
                .build();

        WalletListResponse response = craftgate.wallet().searchWallets(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_wallet_transactions() {
        Long walletId = 1L;

        SearchWalletTransactionsRequest request = SearchWalletTransactionsRequest.builder()
                .build();

        WalletTransactionListResponse response = craftgate.wallet().searchWalletTransactions(walletId, request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void remittance_send() {
        long memberId = 1L;
        BigDecimal price = BigDecimal.valueOf(50);

        CreateRemittanceRequest request = CreateRemittanceRequest.builder()
                .memberId(memberId)
                .price(price)
                .description("Remittance send to memberId" + memberId)
                .remittanceReasonType(RemittanceReasonType.REMITTANCE)
                .build();

        RemittanceResponse response = craftgate.wallet().sendRemittance(request);
        assertNotNull(response);
        assertEquals(request.getMemberId(), response.getMemberId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getDescription(), response.getDescription());
        assertEquals(RemittanceType.SEND, response.getRemittanceType());
        assertEquals(RemittanceReasonType.REMITTANCE, response.getRemittanceReasonType());
    }

    @Test
    void remittance_receive() {
        long memberId = 1L;
        BigDecimal price = BigDecimal.valueOf(50);

        CreateRemittanceRequest request = CreateRemittanceRequest.builder()
                .memberId(memberId)
                .price(price)
                .description("Remittance received from memberId" + memberId)
                .remittanceReasonType(RemittanceReasonType.REMITTANCE)
                .build();

        RemittanceResponse response = craftgate.wallet().receiveRemittance(request);
        assertNotNull(response);
        assertEquals(request.getMemberId(), response.getMemberId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getDescription(), response.getDescription());
        assertEquals(RemittanceType.RECEIVE, response.getRemittanceType());
        assertEquals(RemittanceReasonType.REMITTANCE, response.getRemittanceReasonType());
    }
}
