package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.ReportFileType;
import io.craftgate.request.RetrieveDailyPaymentReportRequest;
import io.craftgate.request.RetrieveDailyTransactionReportRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileReportingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void retrieve_daily_transaction_report() {
        RetrieveDailyTransactionReportRequest retrieveRequest = RetrieveDailyTransactionReportRequest.builder()
                .reportDate(LocalDate.now())
                .fileType(ReportFileType.CSV)
                .build();

        String response = new String(craftgate.fileReporting().retrieveDailyTransactionReport(retrieveRequest));
        assertNotNull(response);
    }

    @Test
    void retrieve_daily_payment_report() {
        RetrieveDailyPaymentReportRequest retrieveRequest = RetrieveDailyPaymentReportRequest.builder()
                .reportDate(LocalDate.now())
                .fileType(ReportFileType.CSV)
                .build();

        String response = new String(craftgate.fileReporting().retrieveDailyPaymentReport(retrieveRequest));
        assertNotNull(response);
    }
}
