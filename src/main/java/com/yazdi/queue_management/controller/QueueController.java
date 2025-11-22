package com.yazdi.queue_management.controller;

import com.yazdi.queue_management.service.IProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {

    private final IProducerService producerService;


    @GetMapping
    public ResponseEntity<?> put(@RequestParam String message){
        producerService.send(message);
        return ResponseEntity.ok(
                "message added to the queue: " + message
        );
    }

}