package io.craftgate.response;

import io.craftgate.model.ReportState;
import io.craftgate.request.dto.ReportFilter;
import lombok.Data;

import java.util.List;

@Data
public class ReportFromTemplateResponse {
    private Long id;
    private ReportState reportState;
    private List<ReportFilter> filters;
    private List<String> columns;
    private Long reportSchemaId;
}
