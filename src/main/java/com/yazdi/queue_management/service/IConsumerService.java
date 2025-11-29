package com.yazdi.queue_management.service;

public interface IConsumerService {

    String readOneMessage();
    void startConsumer(String consumerId);
    void stopConsumer(String consumerId);

}