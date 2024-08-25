package com.jsl.kafka_project_one.consumingandproducingfromstrings.consumer;

import com.jsl.kafka_project_one.consumingandproducingfromstrings.annotations.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@ConsumerService
public class KafkaConsumer {
    @KafkaListener(topics = "new-topic", groupId = "myGroup")
    public void consumeMsg(String message) {
        log.info("Consuming the message from new-topic:: {}", message);
    }
}
