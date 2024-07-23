package com.isi.notification.notification;

import com.isi.notification.kafka.commande.CommandeConfirmation;
import com.isi.notification.kafka.payement.PayementConfirmation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity

public class Notification {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private LocalDateTime dateNotification;

    @Embedded
    private CommandeConfirmation commandeConfirmation;

    @Embedded
    private PayementConfirmation payementConfirmation;
}
