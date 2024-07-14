package com.isi.payement.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPayementConfig {

    @Bean
    public NewTopic paymentTopic(){
        return TopicBuilder
                .name("payement-topic")
                .build();
    }
}
