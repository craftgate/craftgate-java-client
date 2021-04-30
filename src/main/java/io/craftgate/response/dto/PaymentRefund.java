package io.craftgate.response.dto;

import io.craftgate.model.PaymentType;
import io.craftgate.model.RefundDestinationType;
import io.craftgate.model.RefundStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRefund {

    private Long id;
    private LocalDateTime createdDate;
    private RefundStatus refundStatus;
    private RefundDestinationType refundDestinationType;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private String conversationId;
    private String authCode;
    private String hostReference;
    private String transId;
    private PaymentType paymentType;
    private PaymentError error;

}
