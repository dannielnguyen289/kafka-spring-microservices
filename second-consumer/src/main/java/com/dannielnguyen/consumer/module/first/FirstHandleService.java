package com.dannielnguyen.consumer.module.first;

public interface FirstHandleService {
    void execute(String consumerId, String consumerGroup, String payload);
}
