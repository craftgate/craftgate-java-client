package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.exception.CraftgateException;
import io.craftgate.model.*;
import io.craftgate.request.RetrieveDailyTransactionReportRequest;
import io.craftgate.response.*;
import io.craftgate.response.common.ErrorResponse;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
}
