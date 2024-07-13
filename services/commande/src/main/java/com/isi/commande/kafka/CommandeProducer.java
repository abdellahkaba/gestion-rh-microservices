package com.isi.commande.kafka;

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
public class CommandeProducer {

    private final KafkaTemplate<String, CommandeConfirmation> kafkaTemplate;
    public void sendCommandeComfirmation(CommandeConfirmation commandeConfirmation){
        log.info("Envoie de la confirmation");
        Message<CommandeConfirmation> message = MessageBuilder
                .withPayload(commandeConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"commande-topic")
                .build();
        kafkaTemplate.send(message);

    }


}