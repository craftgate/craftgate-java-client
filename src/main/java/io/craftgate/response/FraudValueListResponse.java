package io.craftgate.response;

import io.craftgate.model.FraudValue;
import lombok.Data;

import java.util.List;

@Data
public class FraudValueListResponse {

    private String name;
    private List<FraudValue> values;
}
