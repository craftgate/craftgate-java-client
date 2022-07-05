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
        assertEquals("a,b,c\n10.00000000,username,0.00000000", response);
    }

    @Test
    void retrieve_daily_transaction_report_xlsx() throws IOException {
        RetrieveDailyTransactionReportRequest retrieveRequest = RetrieveDailyTransactionReportRequest.builder()
                .reportDate(LocalDate.now())
                .fileType(ReportFileType.XLSX)
                .build();

        byte[] response = craftgate.fileReporting().retrieveDailyTransactionReport(retrieveRequest);
        try (FileOutputStream stream = new FileOutputStream("/tmp/report-real.xlsx")) {
            stream.write(response);
        }
        assertTrue(Arrays.equals(Files.readAllBytes(new File(this.getClass().getResource("/report.xlsx").getPath()).toPath()), response));
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

    private String readFile(File file) {
        Charset charset = StandardCharsets.UTF_8;
        try (InputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);

            return new String(bytes, charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
