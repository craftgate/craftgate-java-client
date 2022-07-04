package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.exception.CraftgateException;
import io.craftgate.model.*;
import io.craftgate.request.RetrieveDailyTransactionReportRequest;
import io.craftgate.response.*;
import io.craftgate.response.common.ErrorResponse;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FileReportingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "http://localhost:8000");

    @Test
    void retrieve_daily_transaction_report() {
        RetrieveDailyTransactionReportRequest retrieveRequest = RetrieveDailyTransactionReportRequest.builder()
                .reportDate(LocalDate.now())
                .fileType(ReportFileType.CSV)
                .build();

        String response = craftgate.fileReporting().retrieveDailyTransactionReport(retrieveRequest);
        assertEquals("a,b,c", response.trim());
    }

    @Test
    void retrieve_missing_daily_transaction_report() {
        RetrieveDailyTransactionReportRequest retrieveRequest = RetrieveDailyTransactionReportRequest.builder()
                .reportDate(LocalDate.now().minusDays(5))
                .fileType(ReportFileType.CSV)
                .build();

        try {
            craftgate.fileReporting().retrieveDailyTransactionReport(retrieveRequest);
        } catch (CraftgateException e) {
            assertEquals("5010", e.getErrorCode());
            assertEquals("Rapor bulunamadı", e.getErrorDescription());
        }
    }
}
