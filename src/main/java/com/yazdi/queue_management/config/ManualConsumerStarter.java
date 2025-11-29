package com.yazdi.queue_management.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Slf4j
@Component
public class ManualConsumerStarter {
    
    public ManualConsumerStarter(KafkaConsumer<String, String> consumer) {
        consumer.subscribe(List.of("manual-topic"));
        // small warm-up to kick the group
        try {
            consumer.poll(Duration.ofMillis(100));
        } catch (Exception e) {
            log.error(e.getMessage());
            // ignore during startup
        }
    }

}