package io.craftgate.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FraudAllValueListsResponse {
    private List<FraudValueListResponse> items = new ArrayList<>();
}
