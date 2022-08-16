package com.example.seu.web;

import com.example.seu.entity.AreaId;
import com.example.seu.service.AreaIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @Resource
    AreaIdService ais;
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
    @GetMapping("/test")
    public void test()
    {
        AreaId ai=new AreaId();
        ai.setArea("安徽");
        ai.setAreaId(1000);
        ais.addAreaId(ai);
    }


}
