package com.example.gravenettest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.gravenettest.mapper")
public class GraveNetTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraveNetTestApplication.class, args);
    }

}
