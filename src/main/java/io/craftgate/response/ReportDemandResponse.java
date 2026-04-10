package io.craftgate.response;

import io.craftgate.model.ReportPeriod;
import io.craftgate.model.ReportType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportDemandResponse {
    private Long id;
    private ReportType reportType;
    private ReportPeriod reportPeriod;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
