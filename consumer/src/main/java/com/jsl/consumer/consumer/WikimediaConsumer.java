package com.jsl.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikimediaConsumer {
    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeJsonMsg(String message) {
        log.info("Consuming the message from new-topic:: {}", message);
    }
}
