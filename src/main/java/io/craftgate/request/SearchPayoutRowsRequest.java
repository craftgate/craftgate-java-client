package io.craftgate.request;

import io.craftgate.model.FileStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchPayoutRowsRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
    private FileStatus fileStatus;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
