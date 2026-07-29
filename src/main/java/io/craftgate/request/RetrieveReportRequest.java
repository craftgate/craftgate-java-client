package io.craftgate.request;


import io.craftgate.model.ReportFileType;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class RetrieveReportRequest extends BaseRequest {

    private ReportFileType fileType;
}
