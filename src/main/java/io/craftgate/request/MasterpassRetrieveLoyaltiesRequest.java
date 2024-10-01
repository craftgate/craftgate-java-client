package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterpassRetrieveLoyaltiesRequest {
    private String msisdn;
    private String binNumber;
    private String cardName;
}
