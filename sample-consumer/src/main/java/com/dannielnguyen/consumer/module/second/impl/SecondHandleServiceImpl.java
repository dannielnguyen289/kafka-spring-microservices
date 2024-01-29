package com.dannielnguyen.consumer.module.second.impl;

import com.dannielnguyen.consumer.core.base.BaseService;
import com.dannielnguyen.consumer.module.second.SecondHandleRepository;
import com.dannielnguyen.consumer.module.second.SecondHandleService;
import com.dannielnguyen.consumer.module.second.query.InsertConsumerTaskPrt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecondHandleServiceImpl extends BaseService implements SecondHandleService {

    @Autowired
    SecondHandleRepository secondHandleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute(String consumerId, String consumerGroup, String payload) throws RuntimeException {

        InsertConsumerTaskPrt params = new InsertConsumerTaskPrt();
        params.setConsumerId(consumerId);
        params.setConsumerGroup(consumerGroup);
        params.setHandler(getClass().getName());
        params.setPayload(payload);

        this.secondHandleRepository.insertConsumerTask(params);
    }
}
