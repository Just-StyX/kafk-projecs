package com.jsl.kafka_project_one.consumingandproducingfromjson.consumer;

import com.jsl.kafka_project_one.consumingandproducingfromjson.annotations.ConsumerServiceJson;
import com.jsl.kafka_project_one.consumingandproducingfromjson.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@ConsumerServiceJson
public class KafkaConsumerJson {
    @KafkaListener(topics = "new-topic-json", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info("Consuming the message from new-topic:: {}", student.toString());
    }
}
