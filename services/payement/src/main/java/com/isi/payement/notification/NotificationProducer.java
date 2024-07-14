package com.isi.payement.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private final KafkaTemplate<String,PayementNotificationRequest> kafkaTemplate ;

    public void sendNotification(PayementNotificationRequest request){
        log.info("Envoie de notification avec le contenu <{}>" , request);
        Message<PayementNotificationRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC,"payement-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
