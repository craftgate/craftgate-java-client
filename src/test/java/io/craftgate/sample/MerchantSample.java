package io.craftgate.sample;

import io.craftgate.Craftgate;
import io.craftgate.model.*;
import io.craftgate.request.CreateMerchantPosRequest;
import io.craftgate.request.SearchMerchantPosRequest;
import io.craftgate.request.UpdateMerchantPosCommissionsRequest;
import io.craftgate.request.UpdateMerchantPosRequest;
import io.craftgate.request.dto.CreateMerchantPosUser;
import io.craftgate.request.dto.UpdateMerchantPosCommission;
import io.craftgate.request.dto.UpdateMerchantPosUser;
import io.craftgate.response.MerchantPosCommissionListResponse;
import io.craftgate.response.MerchantPosListResponse;
import io.craftgate.response.MerchantPosResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class MerchantSample {

    private final Craftgate craftgate = new Craftgate("api-key", "secret-key", "https://sandbox-api.craftgate.io");

    @Test
    void create_merchant_pos() {
        CreateMerchantPosUser createMerchantPosUser = CreateMerchantPosUser.builder()
                .posOperationType(PosOperationType.STANDARD)
                .posUserType(PosUserType.API)
                .posUsername("username")
                .posPassword("password")
                .build();

        CreateMerchantPosRequest request = CreateMerchantPosRequest.builder()
                .name("my test pos")
                .clientId("client id")
                .terminalId("terminal id")
                .threedsKey("3d secure key")
                .status(PosStatus.AUTOPILOT)
                .currency(Currency.TRY)
                .orderNumber(1)
                .forceThreeDs(false)
                .enableInstallment(true)
                .enableForeignCard(true)
                .enablePaymentWithoutCvc(true)
                .posIntegrator(PosIntegrator.AKBANK)
                .merchantPosUsers(Collections.singletonList(createMerchantPosUser))
                .build();

        MerchantPosResponse response = craftgate.merchant().createMerchantPos(request);
        assertNotNull(response.getId());
        assertNotNull(response.getHostname());
        assertNotNull(response.getAlias());
        assertNotNull(response.getPath());
        assertNotNull(response.getThreedsPath());
        assertEquals(response.getBankName(), "AKBANK T.A.Ş.");
        assertEquals(response.getPosIntegrator(), PosIntegrator.AKBANK);
    }

    @Test
    void update_merchant_pos() {
        Long merchantPosId = 10L;
        UpdateMerchantPosUser merchantPosUser = UpdateMerchantPosUser.builder()
                .id(100L)
                .posOperationType(PosOperationType.STANDARD)
                .posUserType(PosUserType.API)
                .posUsername("username")
                .posPassword("password")
                .build();

        UpdateMerchantPosRequest request = UpdateMerchantPosRequest.builder()
                .name("my updated test pos")
                .hostname("https://www.sanalakpos.com")
                .clientId("updated client id")
                .mode("P")
                .path("/fim/api")
                .port(443)
                .threedsKey("3d secure key")
                .threedsPath("https://www.sanalakpos.com/fim/est3dgate")
                .forceThreeDs(false)
                .enableForeignCard(true)
                .enableInstallment(true)
                .enablePaymentWithoutCvc(true)
                .newIntegration(false)
                .orderNumber(1)
                .supportedCardAssociations(Arrays.asList(CardAssociation.MASTER_CARD, CardAssociation.VISA))
                .merchantPosUsers(Collections.singletonList(merchantPosUser))
                .build();

        MerchantPosResponse response = craftgate.merchant().updateMerchantPos(merchantPosId, request);
        assertNotNull(response.getId());
        assertNotNull(response.getHostname());
        assertNotNull(response.getAlias());
        assertNotNull(response.getPath());
        assertNotNull(response.getThreedsPath());
        assertEquals(response.getBankName(), "AKBANK T.A.Ş.");
        assertEquals(response.getPosIntegrator(), PosIntegrator.AKBANK);
    }

    @Test
    void update_merchant_pos_status() {
        Long merchantPosId = 1L;
        PosStatus posStatus = PosStatus.PASSIVE;

        craftgate.merchant().updateMerchantPosStatus(merchantPosId, posStatus);
    }

    @Test
    void retrieve_merchant_pos() {
        Long merchantPosId = 1L;

        MerchantPosResponse response = craftgate.merchant().retrieve(merchantPosId);

        assertEquals(response.getId(), merchantPosId);
    }

    @Test
    void delete_merchant_pos() {
        Long merchantPosId = 48L;

        craftgate.merchant().deleteMerchantPos(merchantPosId);
    }

    @Test
    void search_merchant_poses() {
        SearchMerchantPosRequest request = SearchMerchantPosRequest.builder()
                .currency(Currency.TRY)
                .forceThreeDs(false)
                .page(0)
                .size(10)
                .build();

        MerchantPosListResponse response = craftgate.merchant().searchMerchantPos(request);
        assertEquals(0, response.getPage());
        assertEquals(10, response.getSize());
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void retrieve_merchant_pos_commissions() {
        Long merchantPosId = 1L;


        MerchantPosCommissionListResponse response = craftgate.merchant().retrieveMerchantPosCommissions(merchantPosId);
        assertFalse(response.getItems().isEmpty());
    }

    @Test
    void update_merchant_pos_commissions() {
        Long merchantPosId = 1L;

        UpdateMerchantPosCommission installment1 = UpdateMerchantPosCommission.builder()
                .installment(1)
                .blockageDay(7)
                .status(Status.ACTIVE)
                .cardBrandName(CardBrand.AXESS.toName())
                .installmentLabel("Single installment")
                .bankOnUsDebitCardCommissionRate(BigDecimal.valueOf(1.0))
                .bankOnUsCreditCardCommissionRate(BigDecimal.valueOf(1.1))
                .bankNotOnUsDebitCardCommissionRate(BigDecimal.valueOf(1.2))
                .bankNotOnUsCreditCardCommissionRate(BigDecimal.valueOf(1.3))
                .bankForeignCardCommissionRate(BigDecimal.valueOf(1.5))
                .build();

        UpdateMerchantPosCommission installment2 = UpdateMerchantPosCommission.builder()
                .installment(2)
                .blockageDay(7)
                .status(Status.ACTIVE)
                .cardBrandName(CardBrand.AXESS.toName())
                .installmentLabel("installment 2")
                .bankOnUsCreditCardCommissionRate(BigDecimal.valueOf(2.1))
                .merchantCommissionRate(BigDecimal.valueOf(2.3))
                .build();

        ArrayList<UpdateMerchantPosCommission> commissions = new ArrayList<>();
        commissions.add(installment1);
        commissions.add(installment2);

        UpdateMerchantPosCommissionsRequest request = UpdateMerchantPosCommissionsRequest.builder()
                .commissions(commissions)
                .build();

        MerchantPosCommissionListResponse response = craftgate.merchant().updateMerchantPosCommissions(merchantPosId, request);
        assertFalse(response.getItems().isEmpty());
    }
}
