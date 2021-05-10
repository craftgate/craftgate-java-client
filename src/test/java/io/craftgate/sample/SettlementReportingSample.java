package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.SettlementType;
import io.craftgate.request.SearchPayoutBouncedTransactionsRequest;
import io.craftgate.request.SearchPayoutCompletedTransactionsRequest;
import io.craftgate.response.PayoutBouncedTransactionListResponse;
import io.craftgate.response.PayoutCompletedTransactionListResponse;
import io.craftgate.response.PayoutDetailResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettlementReportingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_settlement_payout_completed_transactions() {
        SearchPayoutCompletedTransactionsRequest request = SearchPayoutCompletedTransactionsRequest.builder()
                .settlementType(SettlementType.SETTLEMENT)
                .startDate(LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59))
                .build();

        PayoutCompletedTransactionListResponse response = craftgate.settlementReporting().searchPayoutCompletedTransactions(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_bounced_settlement_payout_completed_transactions() {
        SearchPayoutCompletedTransactionsRequest request = SearchPayoutCompletedTransactionsRequest.builder()
                .settlementType(SettlementType.BOUNCED_SETTLEMENT)
                .startDate(LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59))
                .build();

        PayoutCompletedTransactionListResponse response = craftgate.settlementReporting().searchPayoutCompletedTransactions(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_payout_bounced_transactions() {
        SearchPayoutBouncedTransactionsRequest request = SearchPayoutBouncedTransactionsRequest.builder()
                .startDate(LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59))
                .build();

        PayoutBouncedTransactionListResponse response = craftgate.settlementReporting().searchBouncedPayoutTransactions(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void retrieve_payout_details() {
        Long payoutId = 1L;

        PayoutDetailResponse response = craftgate.settlementReporting().retrievePayoutDetails(payoutId);
        assertNotNull(response);
    }
}
