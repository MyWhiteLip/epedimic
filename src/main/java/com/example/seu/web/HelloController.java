package com.example.seu.web;

import com.example.seu.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @Autowired
    public CategoryMapper cm;
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
    @RequestMapping("/set")
    public void set(HttpServletRequest request)
    {
        HttpSession hs=request.getSession();
        System.out.println(hs.getId());
        hs.setAttribute("username",request.getParameter("username"));
        System.out.println(request.getParameter("username"));
    }

}
