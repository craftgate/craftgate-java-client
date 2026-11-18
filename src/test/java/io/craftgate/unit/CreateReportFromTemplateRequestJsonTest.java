package io.craftgate.unit;

import io.craftgate.model.ReportFileType;
import io.craftgate.request.CreateReportFromTemplateRequest;
import io.craftgate.request.common.Jsons;
import io.craftgate.request.dto.ReportFilter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateReportFromTemplateRequestJsonTest {

    private final LocalDateTime startDate = LocalDateTime.of(2025, 11, 19, 9, 15, 31, 622824000);
    private final LocalDateTime endDate = LocalDateTime.of(2025, 11, 27, 9, 15, 31, 622843000);

    @Test
    void should_serialize_report_date_filter_and_file_format() {
        //given
        CreateReportFromTemplateRequest request = CreateReportFromTemplateRequest.builder()
                .filter(ReportFilter.reportDate(startDate, endDate))
                .fileFormats(EnumSet.of(ReportFileType.XLSX))
                .build();

        //when
        String json = Jsons.getGson().toJson(request);

        //then
        assertEquals("{\"filters\":[{\"name\":\"reportDate\",\"values\":[\"2025-11-19T09:15:31.622824\",\"2025-11-27T09:15:31.622843\"]}],\"fileFormats\":[\"XLSX\"]}", json);
    }

    @Test
    void should_omit_file_formats_when_not_set() {
        //given
        CreateReportFromTemplateRequest request = CreateReportFromTemplateRequest.builder()
                .filter(ReportFilter.reportDate(startDate, endDate))
                .build();

        //when
        String json = Jsons.getGson().toJson(request);

        //then
        assertEquals("{\"filters\":[{\"name\":\"reportDate\",\"values\":[\"2025-11-19T09:15:31.622824\",\"2025-11-27T09:15:31.622843\"]}]}", json);
    }

    @Test
    void should_keep_filters_in_insertion_order() {
        //given
        CreateReportFromTemplateRequest request = CreateReportFromTemplateRequest.builder()
                .filter(ReportFilter.builder()
                        .name("status")
                        .values(Collections.<Object>singletonList("SUCCESS"))
                        .build())
                .filter(ReportFilter.reportDate(startDate, endDate))
                .fileFormats(EnumSet.of(ReportFileType.CSV))
                .build();

        //when
        String json = Jsons.getGson().toJson(request);

        //then
        assertEquals("{\"filters\":[{\"name\":\"status\",\"values\":[\"SUCCESS\"]},{\"name\":\"reportDate\",\"values\":[\"2025-11-19T09:15:31.622824\",\"2025-11-27T09:15:31.622843\"]}],\"fileFormats\":[\"CSV\"]}", json);
    }
}
