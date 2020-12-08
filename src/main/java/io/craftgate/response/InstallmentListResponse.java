package io.craftgate.response;

import lombok.Data;
import io.craftgate.response.dto.Installment;

import java.util.List;

@Data
public class InstallmentListResponse {

    private List<Installment> items;
}
