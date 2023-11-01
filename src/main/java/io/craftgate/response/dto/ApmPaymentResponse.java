package io.craftgate.response.dto;

import io.craftgate.model.ApmAdditionalAction;
import io.craftgate.model.ApmType;
import io.craftgate.model.PaymentStatus;
import lombok.Data;

import java.util.List;

@Data
public class ApmPaymentResponse {

    private ApmType apmType;
    private String transactionId;
    private String redirectUrl;
    private List<PaymentTxResponse> paymentTransactions;

}