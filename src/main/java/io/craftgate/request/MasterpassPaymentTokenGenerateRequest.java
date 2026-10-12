package io.craftgate.request;

import io.craftgate.model.Loyalty;
import io.craftgate.model.MasterpassValidationType;
import io.craftgate.request.dto.MasterpassCreatePayment;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MasterpassPaymentTokenGenerateRequest extends BaseRequest {
    private String msisdn;
    private String userId;
    private String binNumber;
    private Boolean forceThreeDS;
    private Boolean isMsisdnValidated;
    private MasterpassCreatePayment createPayment;
    private Integer masterpassIntegrationVersion;
    private Loyalty loyalty;
    private MasterpassValidationType validationType;
}
