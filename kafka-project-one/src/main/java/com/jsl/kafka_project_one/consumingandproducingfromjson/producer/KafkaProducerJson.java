package com.jsl.kafka_project_one.consumingandproducingfromjson.producer;

import com.jsl.kafka_project_one.consumingandproducingfromjson.annotations.ProducerServiceJson;
import com.jsl.kafka_project_one.consumingandproducingfromjson.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@ProducerServiceJson
@RequiredArgsConstructor
public class KafkaProducerJson {
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student) {
        Message<Student> message = MessageBuilder
                                    .withPayload(student)
                                    .setHeader(KafkaHeaders.TOPIC, "new-topic-json").build();
        log.info(String.format("Sending message to new-topic:: %s", message.getPayload()));
        kafkaTemplate.send(message);
    }
}
