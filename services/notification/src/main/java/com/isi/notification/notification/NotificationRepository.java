package com.isi.notification.notification;

import com.isi.notification.kafka.payement.PayementConfirmation;
import com.isi.notification.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification,String> {
}
