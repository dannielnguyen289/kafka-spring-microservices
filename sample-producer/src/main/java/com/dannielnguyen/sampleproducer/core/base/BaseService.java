package com.dannielnguyen.sampleproducer.core.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseService {

    protected final Log LOGGER = LogFactory.getLog(getClass());

}
