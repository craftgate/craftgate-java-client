package io.craftgate.request;


import io.craftgate.model.ReportFileType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveReportRequest {

    private ReportFileType fileType;
}
