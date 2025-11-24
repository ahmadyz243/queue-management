package com.yazdi.queue_management.service.impl;

import com.yazdi.queue_management.service.IConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService implements IConsumerService {

    private final KafkaListenerEndpointRegistry kafkaRegistry;


    @Override
    public String readMessage() {
        return "todo";
    }

    @KafkaListener(id = "testConsumer", topics = "testTopic", groupId = "queue-group", autoStartup = "false")
    public void listenMessage(String message){
        System.out.println("message received:  " + message);
    }

    @Override
    public void startConsumer(String consumerId) {
        log.info("starting consumer: {}", consumerId);
        final MessageListenerContainer container = getConsumerContainer(consumerId);
        container.start();
        log.info("consumer started ============> {}", consumerId);
    }

    @Override
    public void stopConsumer(String consumerId) {
        log.info("stoping consumer: {}", consumerId);
        final MessageListenerContainer container = getConsumerContainer(consumerId);
        container.stop();
        log.info("consumer stoped ============> {}", consumerId);
    }

    private MessageListenerContainer getConsumerContainer(String consumerId){
        final MessageListenerContainer container = kafkaRegistry.getListenerContainer(consumerId);
        if(container == null){
            log.error("consumer not found: {}", consumerId);
            throw new RuntimeException("consumer not found");
        }
        return container;
    }

}