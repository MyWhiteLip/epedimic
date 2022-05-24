package com.example.seu.tool;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.cache.spi.CacheTransactionSynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class getuser {
    @Autowired
    CategoryMapper cm;
    @RequestMapping("/getuser")
    public void get(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        HttpSession hs=request.getSession();
        response.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        User us=cm.getuser(username);
        String res=us.getall();
        JSONObject p=JSONObject.fromObject(res);
        JSONObject js=new JSONObject();
        JSONArray ja=JSONArray.fromObject(p.get("userlist").toString());
        for(int i=0;i<ja.size();i++)
        {
            ja.getJSONObject(i).put("name",cm.getname(ja.getJSONObject(i).get("username").toString()));
        }
        p.put("userlist",ja.toString());

        js.put("msg",p.toString());
        response.getWriter().write(js.toString());

    }
}
