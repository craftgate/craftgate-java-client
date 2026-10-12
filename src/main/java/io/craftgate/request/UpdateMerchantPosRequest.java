package io.craftgate.request;

import io.craftgate.model.CardAssociation;
import io.craftgate.model.PaymentAuthenticationType;
import io.craftgate.request.dto.UpdateMerchantPosUser;
import lombok.Data;

import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UpdateMerchantPosRequest extends BaseRequest {
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
    private Boolean enableLoyalty;
    private Boolean newIntegration;
    private Integer orderNumber;
    private List<CardAssociation> supportedCardAssociations;
    private List<PaymentAuthenticationType> enabledPaymentAuthenticationTypes;
    private List<UpdateMerchantPosUser> merchantPosUsers;
}