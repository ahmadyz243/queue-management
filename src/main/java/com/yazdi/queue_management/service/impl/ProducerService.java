package com.yazdi.queue_management.service.impl;

import com.yazdi.queue_management.service.IProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService implements IProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void sendToTopic(String message, String topicName) {
        synchronized(this){
            try {
                SendResult<String, String> sendResult = kafkaTemplate.send(topicName, message).get();
                log.info("sendResult ===============> {}", sendResult);
            } catch (InterruptedException | ExecutionException e) {
                log.error("sendToTopic error", e);
                throw new RuntimeException(e);
            }
        }
    }

}