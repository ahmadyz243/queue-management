package com.yazdi.queue_management.service.impl;

import com.yazdi.queue_management.service.IProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService implements IProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void send(String message) {
        kafkaTemplate.send("testTopic", message);
    }

}