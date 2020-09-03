package com.sunwc.service7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启服务注册发现
@EnableDiscoveryClient
//开启hystrix
//@EnableCircuitBreaker
//开启feign
@EnableFeignClients
@EnableZuulProxy
public class Service7003Application {
    public static void main(String[] args) {
        SpringApplication.run(Service7003Application.class, args);
    }
}
