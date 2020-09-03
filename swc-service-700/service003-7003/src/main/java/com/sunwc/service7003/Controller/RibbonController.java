package com.sunwc.service7003.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RibbonController {

    @RequestMapping("ribbonTest")
    @ResponseBody
    public void ribbonTest(@RequestParam String name){
        System.out.println(name + "7003");
    }

    @GetMapping("/")
    public String index (){
        return "我是Service003";
    }
}
