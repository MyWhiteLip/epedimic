package com.example.seu.web.home;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class informationhandler {
    @Autowired
    CategoryMapper cm;
    @PostMapping("/updatename")
    public String updatename(@RequestParam("username") String username,@RequestParam("name")String name)
    {
        User a=cm.getuser(username);
        a.setName(name);
        cm.updatename(a);
        return "true";
    }
}
