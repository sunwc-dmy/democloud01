package com.sunwc.service7003.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @RequestMapping("/feignTest")
    @ResponseBody
    public void feignTest(@RequestParam String msg) {
        System.out.println(msg);
    }
}
