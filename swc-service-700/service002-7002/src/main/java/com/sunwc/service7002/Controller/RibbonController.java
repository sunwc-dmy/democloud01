package com.sunwc.service7002.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbonTest",method = RequestMethod.GET)
    @ResponseBody
    public void ribbonTest(){
        String name = "ribbon success";
        restTemplate.getForObject("http://SERVICE-7003/ribbonTest?name="+name,String.class);
        System.out.println("ribbon restTemPlate");
    }
}
