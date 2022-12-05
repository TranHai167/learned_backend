package com.example.selfproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SelfProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfProjectApplication.class, args);
    }
}
