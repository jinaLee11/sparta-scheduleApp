package com.example.spartascheduleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaScheduleAppApplication.class, args);
    }

}
