package io.craftgate.unit;

import io.craftgate.request.CreateMemberRequest;
import io.craftgate.request.common.HashGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashGeneratorTest {

    @Test
    void should_generate_hash() {
        //given
        String expectedSignature = "MJPVYSG6ZHMPUK9YU77G381AXA4QT1WTTV6C0QLJ1E0=";
        CreateMemberRequest request = CreateMemberRequest.builder()
                .memberExternalId("ext-1511")
                .email("haluk.demir@example.com")
                .phoneNumber("905551111111")
                .name("Haluk Demir")
                .identityNumber("11111111110")
                .build();

        //when
        String signature = HashGenerator.generateHash("http://api.craftgate.io", "api-key", "secret-key",
                "rand-2010", request, "/onboarding/v1/buyers");

        //then
        assertEquals(expectedSignature, signature);
    }

    @Test
    void should_generate_hash_when_request_body_null() {
        //given
        String expectedSignature = "IBHUJ+OEQOI9WP6AJMXWKNYH2/BIZ568Q3SPMF6X8PA=";

        //when
        String signature = HashGenerator.generateHash("http://api.craftgate.io", "api-key", "secret-key",
                "rand-2010", null, "/onboarding/v1/buyers");

        //then
        assertEquals(expectedSignature, signature);
    }

}
