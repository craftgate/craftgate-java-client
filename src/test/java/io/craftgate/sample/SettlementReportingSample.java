package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.FileStatus;
import io.craftgate.model.SettlementType;
import io.craftgate.request.SearchPaymentTransactionPayoutsRequest;
import io.craftgate.request.SearchPayoutBouncedTransactionsRequest;
import io.craftgate.request.SearchPayoutCompletedItemsRequest;
import io.craftgate.request.SearchPayoutRowsRequest;
import io.craftgate.response.PaymentTxPayoutListResponse;
import io.craftgate.response.PaymentTxPayoutResponse;
import io.craftgate.response.PayoutBouncedTransactionListResponse;
import io.craftgate.response.PayoutCompletedItemListResponse;
import io.craftgate.response.PayoutRowListResponse;
import io.craftgate.response.SettlementRowResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class SettlementReportingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_settlement_payout_completed_items() {
        SearchPayoutCompletedItemsRequest request = SearchPayoutCompletedItemsRequest.builder()
                .settlementType(SettlementType.SETTLEMENT)
                .startDate(LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59))
                .page(0)
                .size(10)
                .build();

        PayoutCompletedItemListResponse response = craftgate.settlementReporting().searchPayoutCompletedItems(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void search_bounced_settlement_payout_completed_items() {
        SearchPayoutCompletedItemsRequest request = SearchPayoutCompletedItemsRequest.builder()
                .settlementType(SettlementType.BOUNCED_SETTLEMENT)
                .startDate(LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0))
                .endDate(LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59))
                .build();

        PayoutCompletedItemListResponse response = craftgate.settlementReporting().searchPayoutCompletedItems(request);
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
    void retrieve_settlement_row() {
        Long settlementRowId = 1L;

        SettlementRowResponse response = craftgate.settlementReporting().retrieveSettlementRow(settlementRowId);
        assertNotNull(response);
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void search_payout_rows() {
        SearchPayoutRowsRequest request = SearchPayoutRowsRequest.builder()
                .fileStatus(FileStatus.CREATED)
                .startDate(LocalDateTime.now().minusDays(10))
                .endDate(LocalDateTime.now())
                .page(0)
                .size(10)
                .build();

        PayoutRowListResponse response = craftgate.settlementReporting().searchPayoutRows(request);
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void retrieve_payment_transaction_payout() {
        Long paymentTransactionId = 1L;

        PaymentTxPayoutResponse response = craftgate.settlementReporting().retrievePaymentTransactionPayout(paymentTransactionId);
        assertEquals(paymentTransactionId, response.getPaymentTransactionId());
        assertFalse(response.getPayoutItems().isEmpty());
    }

    @Test
    void search_payment_transaction_payouts() {
        SearchPaymentTransactionPayoutsRequest request = SearchPaymentTransactionPayoutsRequest.builder()
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTxPayoutListResponse response = craftgate.settlementReporting().searchPaymentTransactionPayouts(request);
        assertFalse(response.getItems().isEmpty());
    }
}
