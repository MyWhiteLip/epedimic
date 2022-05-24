package com.example.seu.web.customer;

import com.example.seu.mapper.CustomerMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Service {
    @Autowired
    CustomerMapper cm;
    @PostMapping("/question")
    public String question(@RequestParam("username")String username,@RequestParam("question")String question)
    {
        com.example.seu.pojo.customerservice ct= new com.example.seu.pojo.customerservice();
        ct.setQuestion(question);
        ct.setUsername(username);
        cm.insertques(ct);
        return "true";
    }
    @PostMapping("/getquestion")
    public String getquestion()
    {
        List<com.example.seu.pojo.customerservice> questionlist=cm.getall();
        JSONArray ja=new JSONArray();
        for(int i=0;i<questionlist.size();i++)
        {
            JSONObject jo=new JSONObject();
            jo.put("username",questionlist.get(i).getUsername());
            jo.put("question",questionlist.get(i).getQuestion());
            jo.put("id",questionlist.get(i).getId());
            ja.add(jo);
        }
        return ja.toString();
    }
    @PostMapping("/deletequestion")
    public String dealquestion(@RequestParam("id")int id)
    {
        cm.deleteByid(id);
        return "true";
    }
}
