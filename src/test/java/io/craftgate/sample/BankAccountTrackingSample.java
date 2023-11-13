package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.request.SearchBankAccountTrackingRecordsRequest;
import io.craftgate.response.BankAccountTrackingRecordListResponse;
import io.craftgate.response.BankAccountTrackingRecordResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void retrieve_bank_account_tracking_record() {
        Long recordId = 326L;
        BankAccountTrackingRecordResponse response = craftgate.bankAccountTracking().retrieveRecord(recordId);
        assertNotNull(response);
        assertEquals(response.getId(), recordId);
    }
}
