package com.jsl.kafka_project_one.consumingandproducingfromjson.rest;

import com.jsl.kafka_project_one.consumingandproducingfromjson.payload.Student;
import com.jsl.kafka_project_one.consumingandproducingfromjson.producer.KafkaProducerJson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageControllerJson {
    private final KafkaProducerJson kafkaProducer;

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student student
    ) {
        kafkaProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfully");
    }
}
