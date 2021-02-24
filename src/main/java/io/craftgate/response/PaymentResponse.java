package io.craftgate.response;

import io.craftgate.model.*;
import io.craftgate.response.dto.MerchantPos;
import io.craftgate.response.dto.PaymentError;
import io.craftgate.response.dto.PaymentTransaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentResponse {

    private Long id;
    private LocalDateTime createdDate;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private Currency currency;
    private Long buyerMemberId;
    private Integer installment;
    private String conversationId;
    private PaymentType paymentType;
    private PaymentGroup paymentGroup;
    private PaymentStatus paymentStatus;
    private PaymentPhase paymentPhase;
    private Boolean isThreeDS;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private String cardUserKey;
    private String cardToken;
    private Boolean paidWithStoredCard;
    private String binNumber;
    private String lastFourDigits;
    private String authCode;
    private String hostReference;
    private String transId;
    private String orderId;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private MerchantPos pos;
    private PaymentError paymentError;
    private List<PaymentTransaction> paymentTransactions;
}
