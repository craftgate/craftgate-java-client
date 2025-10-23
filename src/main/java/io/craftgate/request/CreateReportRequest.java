package io.craftgate.request;

import io.craftgate.model.ReportPeriod;
import io.craftgate.model.ReportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportRequest {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Builder.Default
    private ReportType reportType = ReportType.TRANSACTION;

    private ReportPeriod reportPeriod;

    private Long merchantPosId;
}
