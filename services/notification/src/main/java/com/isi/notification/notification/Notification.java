package com.isi.notification.notification;

import com.isi.notification.kafka.commande.CommandeConfirmation;
import com.isi.notification.kafka.payement.PayementConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime dateNotification;
    private CommandeConfirmation commandeConfirmation;
    private PayementConfirmation payementConfirmation;

}
