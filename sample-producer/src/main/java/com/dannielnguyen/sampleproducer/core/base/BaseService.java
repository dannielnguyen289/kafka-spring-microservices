package com.dannielnguyen.sampleproducer.core.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class BaseService {

    protected final Log LOGGER = LogFactory.getLog(getClass());

}
