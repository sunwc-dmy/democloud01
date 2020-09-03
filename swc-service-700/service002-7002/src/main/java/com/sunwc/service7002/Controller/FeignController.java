package com.sunwc.service7002.Controller;

import com.sunwc.service7002.Service.FeignFallBackClient;
import com.sunwc.service7002.Service.FeignFallBackFactoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignFallBackFactoryClient feignFallBackClient;

    @RequestMapping(value = "/feignTest",method = RequestMethod.GET)
    public void feignTest(){
        feignFallBackClient.feignTest("feignTest");
    }
}
