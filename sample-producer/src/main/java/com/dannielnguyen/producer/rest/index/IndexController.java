package com.dannielnguyen.producer.rest.index;

import com.dannielnguyen.producer.core.base.BaseController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController("/")
public class IndexController extends BaseController {

    @GetMapping
    String index(){
        return "Hello word";
    }
}
