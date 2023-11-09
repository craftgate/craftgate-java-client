package io.craftgate.request;

import io.craftgate.request.dto.BnplPaymentCartItem;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class InitBnplPaymentRequest extends InitApmPaymentRequest {

    private String bankCode;
    private List<BnplPaymentCartItem> cartItems;

}
