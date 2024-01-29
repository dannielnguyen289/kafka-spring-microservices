package com.dannielnguyen.sampleproducer.rest.producer.impl;

import com.dannielnguyen.sampleproducer.core.base.BaseService;
import com.dannielnguyen.sampleproducer.rest.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl extends BaseService implements ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String KAFKA_TOPIC;

    public void publish(String message) {
        this.LOGGER.debug(this.KAFKA_TOPIC);
        kafkaTemplate.send(this.KAFKA_TOPIC, message);
    }
}
