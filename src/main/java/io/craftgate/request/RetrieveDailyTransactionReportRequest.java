package io.craftgate.request;


import io.craftgate.model.ReportFileType;
import lombok.Data;

import java.time.LocalDate;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveDailyTransactionReportRequest extends BaseRequest {

    private LocalDate reportDate;
    private ReportFileType fileType;
}
