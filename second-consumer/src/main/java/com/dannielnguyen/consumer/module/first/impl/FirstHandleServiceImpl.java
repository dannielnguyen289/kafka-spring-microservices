package com.dannielnguyen.consumer.module.first.impl;

import com.dannielnguyen.consumer.core.base.BaseService;
import com.dannielnguyen.consumer.module.first.FirstHandleRepository;
import com.dannielnguyen.consumer.module.first.FirstHandleService;
import com.dannielnguyen.consumer.module.first.query.InsertConsumerTaskPrt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirstHandleServiceImpl extends BaseService implements FirstHandleService {

    @Autowired
    FirstHandleRepository firstHandleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute(String consumerId, String consumerGroup, String payload) throws RuntimeException {

        InsertConsumerTaskPrt params = new InsertConsumerTaskPrt();
        params.setConsumerId(consumerId);
        params.setConsumerGroup(consumerGroup);
        params.setHandler(getClass().getName());
        params.setPayload(payload);

        this.firstHandleRepository.insertConsumerTask(params);
    }
}
