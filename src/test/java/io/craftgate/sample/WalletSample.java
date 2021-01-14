package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.*;
import io.craftgate.request.*;
import io.craftgate.response.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WalletSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_wallets() {
        SearchWalletRequest request = SearchWalletRequest.builder()
                .memberId(1L)
                .build();

        WalletListResponse response = craftgate.wallet().searchWallets(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_wallet_transactions() {
        Long walletId = 1L;
        SearchWalletTransactionRequest request = SearchWalletTransactionRequest.builder()
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
