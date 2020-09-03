package com.sunwc.service7002.Service;

import com.sunwc.service7002.Component.FeignFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-7003",fallbackFactory = FeignFallBackFactory.class)
public interface FeignFallBackFactoryClient {

    @RequestMapping("/feignTest")
    public void feignTest(@RequestParam String msg);
}
