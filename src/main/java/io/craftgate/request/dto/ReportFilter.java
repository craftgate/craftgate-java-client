package io.craftgate.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportFilter {

    private static final String REPORT_DATE_FILTER_NAME = "reportDate";

    private String name;
    private List<Object> values;

    public static ReportFilter reportDate(LocalDateTime startDate, LocalDateTime endDate) {
        return new ReportFilter(REPORT_DATE_FILTER_NAME, Arrays.<Object>asList(startDate, endDate));
    }
}
