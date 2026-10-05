package io.craftgate.request;


import io.craftgate.model.FraudOperation;
import lombok.Builder;
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
    @Builder.Default
    FraudOperation operation = FraudOperation.PAYMENT;
    String operationId;
}