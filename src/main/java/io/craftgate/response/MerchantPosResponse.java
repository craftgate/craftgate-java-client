package io.craftgate.response;

import io.craftgate.model.*;
import io.craftgate.response.dto.MerchantPosUser;
import lombok.Data;

import java.util.List;

@Data
public class MerchantPosResponse {

    private Long id;
    private PosStatus status;
    private String name;
    private String alias;
    private PosIntegrator posIntegrator;
    private String hostname;
    private String clientId;
    private String posCurrencyCode;
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
    private AutopilotState autopilotState;
    private Currency currency;
    private Long bankId;
    private String bankName;
    private Boolean isPf;
    private List<MerchantPosUser> merchantPosUsers;
    private List<CardAssociation> supportedCardAssociations;
    private List<PaymentAuthenticationType> enabledPaymentAuthenticationTypes;

}