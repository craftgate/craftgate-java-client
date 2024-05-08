package io.craftgate.request;

import io.craftgate.model.Loyalty;
import io.craftgate.request.dto.MasterpassCreatePayment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterpassPaymentTokenGenerateRequest {
    private String msisdn;
    private String userId;
    private String binNumber;
    private Boolean forceThreeDS;
    private Boolean isMsisdnValidated;
    private MasterpassCreatePayment createPayment;
    private Loyalty loyalty;
}
