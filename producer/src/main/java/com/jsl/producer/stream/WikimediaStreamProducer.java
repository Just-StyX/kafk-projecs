package com.jsl.producer.stream;

import com.jsl.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class WikimediaStreamProducer {
    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;

    public WikimediaStreamProducer(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this.wikimediaProducer = wikimediaProducer;
    }

    public void produceToConsumer() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimediaProducer::sendMessage);
    }
}
