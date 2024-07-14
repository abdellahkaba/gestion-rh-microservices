package com.isi.notification.kafka;


import com.isi.notification.email.EmailService;
import com.isi.notification.kafka.commande.CommandeConfirmation;
import com.isi.notification.kafka.payement.PayementConfirmation;
import com.isi.notification.notification.Notification;
import com.isi.notification.notification.NotificationRepository;
import com.isi.notification.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private  final NotificationRepository repository;
    private final EmailService emailService ;
    @KafkaListener(topics = "payement-topic")
    public void consumePayementConfirmationNotification(PayementConfirmation payementConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from commande-topic Topic:: %s", payementConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.PAYEMENT_CONFIRMATION)
                        .dateNotification(LocalDateTime.now())
                        .payementConfirmation(payementConfirmation)
                        .build()
        );

        // todo send email
        var nomClient = payementConfirmation.prenomClient() + " " + payementConfirmation.nomClient() ;
        emailService.sendPayementSuccessEmail(
                payementConfirmation.emailClient(),
                payementConfirmation.prenomClient(),
                payementConfirmation.nomClient(),
                payementConfirmation.montant(),
                payementConfirmation.commandeRef()
        );
    }
    @KafkaListener(topics = "commande-topic")
    public void consumeCommandeConfirmationNotification(CommandeConfirmation commandeConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from commande-topic Topic:: %s", commandeConfirmation));
        repository.save(
                Notification.builder()
                        .type(NotificationType.COMMANDE_CONFIRMATION)
                        .dateNotification(LocalDateTime.now())
                        .commandeConfirmation(commandeConfirmation)
                        .build()
        );

        // todo send email

        var nomClient = commandeConfirmation.client().prenom() + " " + commandeConfirmation.client().nom() ;
        emailService.sendCommandeConfirmationEmail(
                commandeConfirmation.client().email(),
                commandeConfirmation.client().prenom(),
                commandeConfirmation.client().nom(),
                commandeConfirmation.montantTotal(),
                commandeConfirmation.commandeRef(),
                commandeConfirmation.produits()
        );
    }
    //private final EmailService emailService;
}
