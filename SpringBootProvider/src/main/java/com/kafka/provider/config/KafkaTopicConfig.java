package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //delete borra mensaje, compact mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // tiempo de retencion de mensajes  (por defecto es 1min)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // tamaño maximo del segmento (por defecto es 1gb)
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10000"); // tamaño maximo de cada mensaje (por defecto es 1mb)

        return TopicBuilder.name("Santiago-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
