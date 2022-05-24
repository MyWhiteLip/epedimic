package com.example.seu.web.home;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import com.example.seu.tool.verifycode;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class login {
    @Autowired
    CategoryMapper cm;
    @RequestMapping("/login")
    public void test(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        HttpSession hs=request.getSession();
        response.setCharacterEncoding("UTF-8");
        JSONObject res = new JSONObject();
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("code");
        System.out.println("user:"+username+" password:"+password);
        User s=cm.getuser(username);
        System.out.println(code);
        if(code.equals(hs.getAttribute("verifycode"))){
            res.put("success","true");
        }else {
            res.put("success","false");
            res.put("msg","false");response.getWriter().write(res.toString());
            return;
        }
        if(s!=null&&s.getPassword().equals(password)) {

            hs.setAttribute("username",username);
            Cookie c=new Cookie("username",username);
            c.setMaxAge(10800);
            c.setPath("/");
            Cookie d=new Cookie("islogin","true");
            d.setMaxAge(10800);
            d.setPath("/");
            if(username.equals("admin@qq.com"))
            {
                Cookie f=new Cookie("service","true");
                f.setMaxAge(10800);
                f.setPath("/");
                response.addCookie(f); res.put("service","true");
            }
            response.addCookie(c);
            response.addCookie(d);
            res.put("msg","true");

     }
     else {
        res.put("msg","false");
     }

        response.getWriter().write(res.toString());
    }

        @RequestMapping("/getverifycode")
        public void generatecode(HttpServletRequest request, HttpServletResponse response)throws Exception
        {
            HttpSession hs=request.getSession();
            File dir = new File("/usr/local/resource/verifycode");
            int w = 250, h = 80;
            String verifyCode = verifycode.generateVerifyCode(5);
            File file = new File(dir, UUID.randomUUID() + ".jpg");
            String path="http://119.3.176.243/"+file.getName();
            hs.setAttribute("verifycode",verifyCode);
            verifycode.outputImage(w, h, file,verifyCode);
            System.out.println(hs.getId());
            JSONObject res=new JSONObject();
            res.put("msg",path);
            response.getWriter().write(res.toString());
    }

}
