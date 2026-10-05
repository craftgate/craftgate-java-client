package io.craftgate.request;

import io.craftgate.model.ApmType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BnplLimitInquiryRequest extends BaseRequest {

    private ApmType apmType;
    private Long merchantApmId;
    private Map<String, Object> additionalParams;
}
