package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.request.SearchBankAccountTrackingRecordsRequest;
import io.craftgate.response.BankAccountTrackingRecordListResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountTrackingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void search_bank_account_tracking_records() {
        SearchBankAccountTrackingRecordsRequest request = SearchBankAccountTrackingRecordsRequest.builder()
                .page(0)
                .size(10)
                .currency(Currency.TRY)
                .build();

        BankAccountTrackingRecordListResponse response = craftgate.bankAccountTracking().searchRecords(request);
        assertNotNull(response);
        assertTrue(response.getItems().size() > 0);
    }
}
