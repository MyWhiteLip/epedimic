

package com.example.seu.web;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 36000)
@RestController
public class Mynet2 {
    @RequestMapping("/wyq2")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        JSONArray p = new JSONArray();
        File f = new File("data.txt");
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        String H;
        try {
            while ((H = dis.readUTF())!=null) {
                JSONObject ans =JSONObject.fromObject(H);
                p.add(ans);
            }

        }catch (EOFException e) {
            JSONObject fina = new JSONObject();
            fina.put("ans", p.toString());
            response.getWriter().write(fina.toString());
        }
    }

}