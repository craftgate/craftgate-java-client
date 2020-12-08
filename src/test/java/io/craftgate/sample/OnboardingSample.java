package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.MemberType;
import io.craftgate.request.CreateMemberRequest;
import io.craftgate.request.SearchMembersRequest;
import io.craftgate.request.UpdateMemberRequest;
import io.craftgate.response.MemberListResponse;
import io.craftgate.response.MemberResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class OnboardingSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://api.craftgate.io");

    @Test
    void create_sub_merchant_member() {
        CreateMemberRequest request = CreateMemberRequest.builder()
                .isBuyer(false)
                .isSubMerchant(true)
                .contactName("Haluk")
                .contactSurname("Demir")
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .iban("TR930006701000000001111111")
                .identityNumber("11111111110")
                .legalCompanyTitle("Dem Zeytinyağı Üretim Ltd. Şti.")
                .name("Dem Zeytinyağı Üretim Ltd. Şti.")
                .memberType(MemberType.LIMITED_OR_JOINT_STOCK_COMPANY)
                .memberExternalId(UUID.randomUUID().toString())
                .taxNumber("1111111114")
                .taxOffice("Erenköy")
                .address("Suadiye Mah. Örnek Cd. No:23, 34740 Kadıköy/İstanbul")
                .build();

        MemberResponse response = craftgate.onboarding().createMember(request);
        assertNotNull(response.getId());
        assertEquals(request.getContactName(), response.getContactName());
        assertEquals(request.getContactSurname(), response.getContactSurname());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getIban(), response.getIban());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
        assertEquals(request.getLegalCompanyTitle(), response.getLegalCompanyTitle());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getMemberType(), response.getMemberType());
        assertEquals(request.getMemberExternalId(), response.getMemberExternalId());
        assertEquals(request.getTaxNumber(), response.getTaxNumber());
        assertEquals(request.getTaxOffice(), response.getTaxOffice());
        assertEquals(request.getAddress(), response.getAddress());
    }

    @Test
    void update_sub_merchant() {
        Long memberId = 1L;

        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .isBuyer(false)
                .isSubMerchant(true)
                .contactName("Haluk")
                .contactSurname("Demir")
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .iban("TR930006701000000001111111")
                .identityNumber("11111111110")
                .legalCompanyTitle("Dem Zeytinyağı Üretim Ltd. Şti.")
                .name("Dem Zeytinyağı Üretim Ltd. Şti.")
                .memberType(MemberType.LIMITED_OR_JOINT_STOCK_COMPANY)
                .taxNumber("1111111114")
                .taxOffice("Erenköy")
                .address("Suadiye Mah. Örnek Cd. No:23, 34740 Kadıköy/İstanbul")
                .build();

        MemberResponse response = craftgate.onboarding().updateMember(memberId, request);
        assertEquals(memberId, response.getId());
        assertEquals(request.getContactName(), response.getContactName());
        assertEquals(request.getContactSurname(), response.getContactSurname());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getIban(), response.getIban());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
        assertEquals(request.getLegalCompanyTitle(), response.getLegalCompanyTitle());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getTaxNumber(), response.getTaxNumber());
        assertEquals(request.getTaxOffice(), response.getTaxOffice());
        assertEquals(request.getAddress(), response.getAddress());
    }

    @Test
    void retrieve_sub_merchant() {
        Long memberId = 1L;

        MemberResponse response = craftgate.onboarding().retrieveMember(memberId);
        assertEquals(memberId, response.getId());
    }

    @Test
    void search_sub_merchants() {
        List<Long> memberIds = new ArrayList<Long>() {{
            add(1L);
            add(2L);
        }};

        SearchMembersRequest request = SearchMembersRequest.builder()
                .memberIds(memberIds)
                .name("Zeytinyağı Üretim")
                .build();

        MemberListResponse response = craftgate.onboarding().searchMembers(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void create_buyer_member() {
        CreateMemberRequest request = CreateMemberRequest.builder()
                .isBuyer(true)
                .isSubMerchant(false)
                .memberExternalId(UUID.randomUUID().toString())
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .name("Haluk Demir")
                .identityNumber("11111111110")
                .build();

        MemberResponse response = craftgate.onboarding().createMember(request);
        assertNotNull(response.getId());
        assertEquals(request.getMemberExternalId(), response.getMemberExternalId());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
    }

    @Test
    void update_buyer() {
        Long memberId = 1L;

        UpdateMemberRequest request = UpdateMemberRequest.builder()
                .isBuyer(true)
                .isSubMerchant(false)
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .name("Haluk Demir")
                .identityNumber("11111111110")
                .build();

        MemberResponse response = craftgate.onboarding().updateMember(memberId, request);
        assertEquals(memberId, response.getId());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
    }

    @Test
    void retrieve_buyer() {
        Long memberId = 1L;

        MemberResponse response = craftgate.onboarding().retrieveMember(memberId);
        assertEquals(memberId, response.getId());
    }
}
