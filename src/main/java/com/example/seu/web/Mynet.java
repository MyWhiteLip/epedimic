package com.example.seu.web;




import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class Mynet {
    @RequestMapping("/wyq1")
    public void test(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject res = new JSONObject();
        JSONObject ans=new JSONObject();
        String date= request.getParameter("date");
        String type=request.getParameter("who");
        String detail=request.getParameter("detail");
        ans.put("date",date);
        ans.put("who",type);
        ans.put("detail",detail);
        res.put("success","true");
        response.getWriter().write(res.toString());
        File f=new File("data.txt");
      FileOutputStream fos=new FileOutputStream(f,true);
      DataOutputStream dos=new DataOutputStream(fos);
       dos.writeUTF(ans.toString());
       response.getWriter().write(res.toString());

    }

}