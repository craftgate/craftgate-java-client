package io.craftgate.unit;

import io.craftgate.Craftgate;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CraftgateTest {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key");

    @Test
    void should_validate_3D_secure_callback_verified() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "1d3fa1e51fe7c350185c5a7f8c3ff513a991367b08c16a56f4ab9abeb738a1e1");
            put("paymentId", "5");
            put("conversationData", "conversation-data");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertTrue(isVerified);
    }

    @Test
    void should_validate_3D_secure_callback_verified_even_params_has_nullable_value() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "a097f0231031a88f2d687b510afca2505ccd2977d6421be4c3784666703f6f25");
            put("paymentId", "5");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertTrue(isVerified);
    }

    @Test
    void should_not_validate_3D_secure_callback_when_hashes_are_not_equal() {
        //given
        String merchantThreeDsCallbackKey = "merchantThreeDsCallbackKeySndbox";
        Map<String, String> params = new HashMap<String, String>() {{
            put("hash", "39427942bcaasjaduqabzhdancaASasdhbcxjancakjscace82");
            put("paymentId", "5");
            put("conversationData", "conversation-data");
            put("conversationId", "conversation-id");
            put("status", "SUCCESS");
            put("completeStatus", "WAITING");
        }};

        //when
        boolean isVerified = craftgate.is3DSecureCallbackVerified(merchantThreeDsCallbackKey, params);

        //then
        assertFalse(isVerified);
    }
}
