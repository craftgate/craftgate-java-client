package io.craftgate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudValue {
    private String id;
    private String label;
    private String value;
    private Integer expireInSeconds;
}
