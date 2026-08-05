package io.craftgate.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MasterpassRetrieveLoyaltiesRequest extends BaseRequest {
    private String msisdn;
    private String binNumber;
    private String cardName;
    private Integer masterpassIntegrationVersion;
}
