package io.craftgate.request;


import io.craftgate.model.ReportFileType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RetrieveDailyTransactionReportRequest {

    private LocalDate reportDate;
    private ReportFileType fileType;
}
