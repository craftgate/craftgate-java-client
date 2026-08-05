package io.craftgate.request;

import io.craftgate.model.ReportPeriod;
import io.craftgate.model.ReportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateReportRequest extends BaseRequest {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Builder.Default
    private ReportType reportType = ReportType.TRANSACTION;

    @Builder.Default
    private ReportPeriod reportPeriod = ReportPeriod.INSTANT;
}
