package io.craftgate.request;


import io.craftgate.model.FraudOperation;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCardFingerprintFraudValueListRequest {

    String label;
    Integer durationInSeconds;
    FraudOperation operation = FraudOperation.PAYMENT;
    String operationId;
}