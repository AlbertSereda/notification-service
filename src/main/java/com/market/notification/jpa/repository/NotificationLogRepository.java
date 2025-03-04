package com.market.notification.jpa.repository;

import com.market.notification.jpa.entity.NotificationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLogEntity, Long> {

}
