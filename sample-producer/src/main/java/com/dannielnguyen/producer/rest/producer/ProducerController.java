package com.dannielnguyen.producer.rest.producer;

import com.dannielnguyen.producer.core.base.BaseController;
import com.dannielnguyen.producer.rest.producer.dto.PublishEventReqBody;
import com.dannielnguyen.producer.rest.producer.dto.PublishEventResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/producer")
public class ProducerController extends BaseController {

    @Autowired
    ProducerService producerService;

    @PostMapping
    PublishEventResBody publish(@RequestBody PublishEventReqBody body){

        this.producerService.publish(body.message());

        return new PublishEventResBody("Your event was published");
    }
}
