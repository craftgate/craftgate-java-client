package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveIVRCardRequest {

    private String callToken;
    private String cardUserKey;
}
