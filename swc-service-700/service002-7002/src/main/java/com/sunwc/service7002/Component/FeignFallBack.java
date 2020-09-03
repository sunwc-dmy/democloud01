package com.sunwc.service7002.Component;

import com.sunwc.service7002.Service.FeignFallBackClient;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBack implements FeignFallBackClient {

    @Override
    public void feignTest(String msg) {
        System.out.println("feign调用，服务熔断" + msg);
    }
}
