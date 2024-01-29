package com.dannielnguyen.consumer.module.second;

public interface SecondHandleService {
    void execute(String consumerId, String consumerGroup, String payload);
}
