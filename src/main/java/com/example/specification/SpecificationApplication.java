package com.example.specification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class SpecificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecificationApplication.class, args);
    }

}
