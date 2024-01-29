package com.dannielnguyen.sampleconsumer.module.first.impl;

import com.dannielnguyen.sampleconsumer.core.base.BaseService;
import com.dannielnguyen.sampleconsumer.module.first.FirstHandleService;
import org.springframework.stereotype.Service;

@Service
public class FirstHandleServiceImpl extends BaseService implements FirstHandleService {
    @Override
    public void execute() throws RuntimeException {
        return;
    }
}
