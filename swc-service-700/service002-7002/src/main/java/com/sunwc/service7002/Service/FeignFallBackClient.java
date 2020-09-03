package com.sunwc.service7002.Service;

import com.sunwc.service7002.Component.FeignFallBack;
import com.sunwc.service7002.Controller.FeignController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-7001",fallback = FeignFallBack.class,configuration = FeignController.class)
public interface FeignFallBackClient {

    @RequestMapping("/feignTest")
    public void feignTest(@RequestParam String msg);
}
