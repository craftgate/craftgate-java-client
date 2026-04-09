package io.craftgate.request;

import io.craftgate.model.ApmType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BnplLimitInquiryRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private Map<String, Object> additionalParams;
}
