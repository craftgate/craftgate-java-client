package io.craftgate.unit;

import io.craftgate.request.CreateMemberRequest;
import io.craftgate.request.common.HashGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashGeneratorTest {

    @Test
    void should_generate_hash() {
        //given
        String expectedSignature = "QQO5OHUUCNZHD9SJC3RFDQBHHX1UQQIWSJYL3XOQAYA=";
        CreateMemberRequest request = CreateMemberRequest.builder()
                .memberExternalId("ext-1511")
                .email("haluk.demir@example.com")
                .phoneNumber("905551111111")
                .name("Haluk Demir")
                .identityNumber("11111111110")
                .build();

        //when
        String signature = HashGenerator.generateHash("http://api.craftgate.io", "api-key", "secret-key",
                "rand-2010", request, "/onboarding/v1/members");

        //then
        assertEquals(expectedSignature, signature);
    }

    @Test
    void should_generate_hash_when_request_body_null() {
        //given
        String expectedSignature = "LECLRGZXO5U+OQ3V33VIQTBLU2FOPBIH78KQ6WJWNDQ=";

        //when
        String signature = HashGenerator.generateHash("http://api.craftgate.io", "api-key", "secret-key",
                "rand-2010", null, "/onboarding/v1/members");

        //then
        assertEquals(expectedSignature, signature);
    }
}
