package io.craftgate.request;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.PaymentAuthenticationType;
import io.craftgate.request.dto.UpdateMerchantPosUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateMerchantPosRequest {
    private String name;
    private String hostname;
    private String clientId;
    private String mode;
    private String path;
    private Integer port;
    private String posnetId;
    private String terminalId;
    private String threedsPosnetId;
    private String threedsTerminalId;
    private String threedsKey;
    private String threedsPath;
    private Boolean enableForeignCard;
    private Boolean enableInstallment;
    private Boolean enablePaymentWithoutCvc;
    private Boolean newIntegration;
    private Integer orderNumber;
    private List<CardAssociation> supportedCardAssociations;
    private List<PaymentAuthenticationType> enabledPaymentAuthenticationTypes;
    private List<UpdateMerchantPosUser> merchantPosUsers;
}