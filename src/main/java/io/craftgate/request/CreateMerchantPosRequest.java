package io.craftgate.request;

import io.craftgate.model.Currency;
import io.craftgate.model.PosIntegrator;
import io.craftgate.model.PosStatus;
import io.craftgate.request.dto.CreateMerchantPosUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateMerchantPosRequest {

    @Builder.Default
    private PosStatus status = PosStatus.AUTOPILOT;
    private String name;
    private String clientId;
    private Currency currency;
    private String posnetId;
    private String terminalId;
    private String threedsPosnetId;
    private String threedsTerminalId;
    private String threedsKey;
    private Boolean forceThreeDs;
    private Boolean enableForeignCard;
    private Boolean enableInstallment;
    private Boolean enablePaymentWithoutCvc;
    private Boolean newIntegration;
    private Integer orderNumber;
    private PosIntegrator posIntegrator;
    private List<CreateMerchantPosUser> merchantPosUsers;
}
