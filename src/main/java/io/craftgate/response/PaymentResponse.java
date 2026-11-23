package io.craftgate.response;

import io.craftgate.response.common.BasePaymentResponse;
import io.craftgate.response.dto.PaymentTransaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentResponse extends BasePaymentResponse {

    private String cardUserKey;
    private String cardToken;
    private Map<String,Object> additionalData;
    private List<PaymentTransaction> paymentTransactions;
}
