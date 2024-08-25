package com.jsl.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WikimediaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${application.producer.topic}")
    private String topic;

    public void sendMessage(String message) {
        log.info("Sending message to {}:: {}", topic, message);
        kafkaTemplate.send(topic, message);
    }
}
