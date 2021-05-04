package io.craftgate.request;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CreateInstantWalletSettlementRequest {

    private Set<Long> excludedSubMerchantMemberIds;
}