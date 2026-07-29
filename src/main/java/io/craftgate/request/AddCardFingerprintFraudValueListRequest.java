package io.craftgate.request;


import io.craftgate.model.FraudOperation;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import io.craftgate.request.common.BaseRequest;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
public class AddCardFingerprintFraudValueListRequest extends BaseRequest {

    String label;
    Integer durationInSeconds;
    FraudOperation operation = FraudOperation.PAYMENT;
    String operationId;
}