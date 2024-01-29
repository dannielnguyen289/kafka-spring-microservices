package com.dannielnguyen.consumer.core.base;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BaseService {
    protected final Log LOGGER = LogFactory.getLog(getClass());
}
