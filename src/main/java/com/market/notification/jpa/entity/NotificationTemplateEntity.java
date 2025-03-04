package com.market.notification.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notification_template")
@Schema(description = "Notification templates in JSON format")
public class NotificationTemplateEntity {

    @Id
    @Column(name = "id")
    @Schema(description = "Unique identifier for the notification template")
    private Integer id;

    @Column(name = "template", nullable = false, columnDefinition = "jsonb")
    @Schema(description = "JSON template for notifications")
    private String template;

    @Column(name = "notification_type", nullable = false, length = 10)
    @Schema(description = "Type of notification")
    private String notificationType;
}