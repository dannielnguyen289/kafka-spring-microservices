package com.dannielnguyen.consumer.module.second.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertConsumerTaskPrt {
    Long id;
    String consumerId;
    String consumerGroup;
    String handler;
    String payload;
}
