package com.kafka.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {


    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    //con kafkalistener se escuchan los mensajes que se envian
    @KafkaListener(topics = {"Santiago-Topic"}, groupId = "my-group-id")
    public void listener(String message){
        logger.info("Mensaje recibido, el mensaje es: " + message);
    }
}
