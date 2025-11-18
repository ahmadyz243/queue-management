package com.yazdi.queue_management.service.impl;

import com.yazdi.queue_management.service.IConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService implements IConsumerService {

    @Override
    public String readMessage() {
        return "todo";
    }

    @KafkaListener(topics = "testTopic", groupId = "queue-group")
    public void listenMessage(String message){
        System.out.println("message received:  " + message);
    }

}