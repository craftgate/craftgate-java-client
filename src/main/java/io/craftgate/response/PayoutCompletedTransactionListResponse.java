package io.craftgate.response;

import io.craftgate.response.dto.PayoutCompletedTransaction;
import lombok.Data;

import java.util.List;

@Data
public class PayoutCompletedTransactionListResponse {

    private List<PayoutCompletedTransaction> items;
}
