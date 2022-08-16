package com.example.seu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.example.seu.mapper")
public class SeuApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(SeuApplication.class, args);

    }

}
