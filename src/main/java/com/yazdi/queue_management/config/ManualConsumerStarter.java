package com.yazdi.queue_management.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class ManualConsumerStarter {
    public ManualConsumerStarter(KafkaConsumer<String, String> consumer) {
        consumer.subscribe(List.of("manual-topic"));
        // warm-up poll (non-blocking) to kick group join
        consumer.poll(Duration.ofMillis(100));
    }

}