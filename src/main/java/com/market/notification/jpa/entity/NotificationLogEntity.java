package com.market.notification.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification_log")
@Schema(description = "Sent notifications")
public class NotificationLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier for the notification log entry")
    private Long id;

    @Column(name = "user_id", nullable = false)
    @Schema(description = "Identifier of the user receiving the notification")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    @Schema(description = "Identifier of the notification template")
    private NotificationTemplateEntity template;

    @Column(name = "notification_text", nullable = false, columnDefinition = "jsonb")
    @Schema(description = "JSON data for the specific notification")
    private String notificationText;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @Schema(description = "Date of the notification")
    private LocalDateTime creationDate = LocalDateTime.now();
}
