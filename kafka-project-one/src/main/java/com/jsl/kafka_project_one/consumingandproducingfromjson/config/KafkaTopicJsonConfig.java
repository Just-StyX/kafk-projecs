package com.jsl.kafka_project_one.consumingandproducingfromjson.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicJsonConfig {
    @Bean
    public NewTopic newTopicJson() {
        return TopicBuilder.name("new-topic-json").build();
    }
}
