package io.craftgate.response;

import io.craftgate.model.Loyalty;
import io.craftgate.response.dto.MerchantPos;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveLoyaltiesResponse {
    private String cardBrand;
    private Boolean force3ds;
    private MerchantPos pos;
    private List<Loyalty> loyalties;
}
