package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchWalletsRequest {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;

    private Long memberId;
}
