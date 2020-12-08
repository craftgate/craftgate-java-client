package io.craftgate.response.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse<T> {

    @Builder.Default
    private List<T> items = new ArrayList<>();
    private Integer page;
    private Integer size;
    private Long totalSize;
}
