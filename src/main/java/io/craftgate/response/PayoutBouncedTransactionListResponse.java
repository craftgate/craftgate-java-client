package io.craftgate.response;

import io.craftgate.response.dto.PayoutBouncedTransaction;
import lombok.Data;

import java.util.List;

@Data
public class PayoutBouncedTransactionListResponse {

    private List<PayoutBouncedTransaction> items;
}
