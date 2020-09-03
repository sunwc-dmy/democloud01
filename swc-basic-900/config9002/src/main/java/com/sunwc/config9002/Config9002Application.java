package com.sunwc.config9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config9002Application {
    public static void main(String[] args) {
        SpringApplication.run(Config9002Application.class, args);
    }
}
