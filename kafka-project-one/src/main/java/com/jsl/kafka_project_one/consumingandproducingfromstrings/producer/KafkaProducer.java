package com.jsl.kafka_project_one.consumingandproducingfromstrings.producer;

import com.jsl.kafka_project_one.consumingandproducingfromstrings.annotations.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@ProducerService
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(String.format("Sending message to new-topic:: %s", message));
        kafkaTemplate.send("new-topic", message);
    }
}
