package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.request.CreateInstantWalletSettlementRequest;
import io.craftgate.response.SettlementResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SettlementSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_instant_wallet_settlement() {
        CreateInstantWalletSettlementRequest request = CreateInstantWalletSettlementRequest.builder()
                .build();

        SettlementResponse response = craftgate.settlement().createInstantWalletSettlement(request);
        assertNotNull(response.getSettlementResultStatus());
    }
}
