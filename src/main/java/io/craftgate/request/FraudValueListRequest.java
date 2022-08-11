package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudValueListRequest {
    private String listName;
    private String value;
    private Integer durationInSeconds;
}
