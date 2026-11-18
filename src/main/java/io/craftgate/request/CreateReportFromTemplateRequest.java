package io.craftgate.request;

import io.craftgate.model.ReportFileType;
import io.craftgate.request.common.BaseRequest;
import io.craftgate.request.dto.ReportFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateReportFromTemplateRequest extends BaseRequest {

    @Singular
    private List<ReportFilter> filters;

    private Set<ReportFileType> fileFormats;
}
