package io.craftgate.response;

import io.craftgate.response.common.BasePaymentResponse;
import io.craftgate.response.dto.PaymentTransaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentResponse extends BasePaymentResponse {

    private String cardUserKey;
    private String cardToken;
    private List<PaymentTransaction> paymentTransactions;
}
