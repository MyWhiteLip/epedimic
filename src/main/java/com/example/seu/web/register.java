package com.example.seu.web;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class register {
    @Autowired
    CategoryMapper cm;
    @RequestMapping("/register")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        JSONObject res = new JSONObject();
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("user:" + username + " password:" + password);
        User a=new User();
        a.setUser(username);
        a.setPassword(password);

        if (cm.getuser(username)==null) {
            res.put("success", "true");
            cm.insert(a);

        } else {
            res.put("success", "false");
        }
        response.getWriter().write(res.toString());

    }
}


