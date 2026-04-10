package io.craftgate.request.dto;

import io.craftgate.model.PosIntegrator;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DepositToCardPaymentIntegratorDto {

    private PosIntegrator name;
    private Map<String, Object> data;
}
