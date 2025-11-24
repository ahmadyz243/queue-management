package com.yazdi.queue_management.service;

public interface IProducerService {

    void sendToTopic(String message, String topicName);

}