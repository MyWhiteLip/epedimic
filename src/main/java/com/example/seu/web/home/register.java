package com.example.seu.web.home;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import com.example.seu.tool.EmailNotofication;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class register {
    private  static HashMap<String,String> codemap=new HashMap<>();
    @Autowired
    CategoryMapper cm;
    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession hs=request.getSession();
        response.setCharacterEncoding("UTF-8");
        JSONObject res = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code=request.getParameter("code");
        User a=new User();
        a.setUser(username);
        a.setPassword(password);
        a.setChatmessagelist("[]");
        a.setUserlist("[]");
        a.setImg("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
        a.setName("用户"+System.currentTimeMillis()%1000);
        a.setMarked("[]");

        if (cm.getuser(username)==null&&codemap.get(username)!=null&&codemap.get(username).equals(code)) {
            codemap.remove(username);
            res.put("msg", "true");
            hs.setAttribute("username",username);
            cm.insert(a);
            Cookie c=new Cookie("username",username);
            c.setMaxAge(10800);
            c.setPath("/");
            Cookie d=new Cookie("islogin","true");
            d.setMaxAge(10800);
            d.setPath("/");
            response.addCookie(c);
            response.addCookie(d);

        } else {
            res.put("msg", "false");
        }
        response.getWriter().write(res.toString());

    }

    @RequestMapping("/emailconfirm")
    public void emailconfirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        JSONObject res = new JSONObject();
        String email= request.getParameter("username");
        EmailNotofication enf=new EmailNotofication();
        if (cm.getuser(email)==null) {
            String code=code();
            codemap.put(email,code);
            if( enf.senEmail("<h1>欢迎您注册！</h1><br><h1>您的验证码是： "+code+"</h1><h1>如果非您本人操作，请忽略此邮件</h1>",email)) {
                res.put("msg", "true");
            }
            else
            {
                res.put("msg", "false");
            }
        } else {
            res.put("msg", "false");
        }
        response.getWriter().write(res.toString());
    }
    public static String code()
    {
        Random random=new Random();
        //数字加字母的验证码
        String s="01233456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String code="";

        for(int i=0;i<5;i++) {
            int index = random.nextInt(s.length());
            //去重
            if (code.indexOf(s.charAt(index)) == -1) {
                code += String.valueOf(s.charAt(index));
            } else {
                i--;
            }
        }
        return code;
    }


}


