package io.craftgate.response;

import io.craftgate.response.dto.Installment;
import lombok.Data;

import java.util.List;

@Data
public class InstallmentListResponse {

    private List<Installment> items;
}
