package com.dannielnguyen.consumer.module.first.impl;

import com.dannielnguyen.consumer.core.base.BaseService;
import com.dannielnguyen.consumer.module.first.FirstHandleRepository;
import com.dannielnguyen.consumer.module.first.FirstHandleService;
import com.dannielnguyen.consumer.module.first.query.InsertConsumerTaskPrt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstHandleServiceImpl extends BaseService implements FirstHandleService {

    @Value("${kafka.consumer.id}")
    private String consumerId;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroup;

    @Autowired
    FirstHandleRepository firstHandleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute(String payload) throws RuntimeException {

        InsertConsumerTaskPrt params = new InsertConsumerTaskPrt();
        params.setConsumerId(this.consumerId);
        params.setConsumerGroup(this.consumerGroup);
        params.setHandler(getClass().getName());
        params.setPayload(payload);

        this.firstHandleRepository.insertConsumerTask(params);

        return;
    }
}
