package com.yazdi.queue_management.controller;

import com.yazdi.queue_management.service.IConsumerService;
import com.yazdi.queue_management.service.IProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {

    private final IProducerService producerService;
    private final IConsumerService consumerService;


    @GetMapping
    public ResponseEntity<?> putToTopic(@RequestParam String message, @RequestParam String topicName) {
        log.info("put : message =====================> {}", message);
        producerService.sendToTopic(message, topicName);
        return ResponseEntity.ok(
                "message added to the topic: " + message
        );
    }

    @GetMapping("/start-consumer/{consumerId}")
    public ResponseEntity<?> startConsumer(@PathVariable String consumerId) {
        log.info("startConsumer; consumerId: {} ", consumerId);
        consumerService.startConsumer(consumerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stop-consumer/{consumerId}")
    public ResponseEntity<?> stopConsumer(@PathVariable String consumerId) {
        log.info("stopConsumer; consumerId: {} ", consumerId);
        consumerService.stopConsumer(consumerId);
        return ResponseEntity.ok().build();
    }

}