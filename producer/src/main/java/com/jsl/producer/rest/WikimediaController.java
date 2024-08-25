package com.jsl.producer.rest;

import com.jsl.producer.stream.WikimediaStreamProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wikimedia")
public class WikimediaController {
    private final WikimediaStreamProducer streamProducer;

    @GetMapping
    public void startPublishing() {
        streamProducer.produceToConsumer();
    }
}
