package io.craftgate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookData {

    private WebhookEventType eventType;
    private LocalDateTime eventTime;
    private Long eventTimestamp;
    private WebhookStatus status;
    private String payloadId;
}