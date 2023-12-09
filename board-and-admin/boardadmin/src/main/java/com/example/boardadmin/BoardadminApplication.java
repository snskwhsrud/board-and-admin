package com.example.boardadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardadminApplication.class, args);
    }

}
