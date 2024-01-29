package com.dannielnguyen.sampleproducer.core.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public abstract class BaseController {

    protected final Log LOGGER = LogFactory.getLog(getClass());
}
