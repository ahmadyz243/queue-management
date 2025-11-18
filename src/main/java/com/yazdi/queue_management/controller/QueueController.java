package com.yazdi.queue_management.controller;

import com.yazdi.queue_management.service.IProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {

    private final IProducerService producerService;


    @PostMapping
    public ResponseEntity<?> put(@RequestBody String message){
        producerService.send(message);
        return ResponseEntity.ok(
                "message added to the queue: " + message
        );
    }

}