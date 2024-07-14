package com.isi.notification.notification;

import com.isi.notification.kafka.payement.PayementConfirmation;
import com.isi.notification.notification.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
