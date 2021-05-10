package io.craftgate.response.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListResponse<T> {

    private List<T> items = new ArrayList<>();
    private Integer page;
    private Integer size;
    private Long totalSize;
}
