package com.sunwc.admin9001;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Admin9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Admin9001Application.class, args);
    }
}
