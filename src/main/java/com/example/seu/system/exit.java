package com.example.seu.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exit {
    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/stop")
    public String stop() {
        // 加上自己的权限验证
        SpringApplication.exit(applicationContext);
        return "ok";
    }
}
