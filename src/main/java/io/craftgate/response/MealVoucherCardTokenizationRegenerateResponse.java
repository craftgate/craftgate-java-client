package io.craftgate.response;

import io.craftgate.model.ApmAdditionalAction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealVoucherCardTokenizationRegenerateResponse {

    private ApmAdditionalAction additionalAction;
    private String sessionId;
    private String htmlContent;
    private String redirectUrl;
}
