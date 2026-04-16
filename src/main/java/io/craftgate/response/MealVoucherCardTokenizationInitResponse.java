package io.craftgate.response;

import io.craftgate.model.AdditionalAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealVoucherCardTokenizationInitResponse {

    private AdditionalAction additionalAction;
    private String sessionId;
    private String htmlContent;
    private String redirectUrl;
}
