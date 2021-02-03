package io.craftgate.response.dto;

import lombok.Data;

@Data
public class PaymentError {
    private String errorCode;
    private String errorDescription;
    private String errorGroup;
}
