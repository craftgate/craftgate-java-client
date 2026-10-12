package io.craftgate.request;

import io.craftgate.model.FileStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SearchPayoutRowsRequest extends BaseRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
    private FileStatus fileStatus;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
