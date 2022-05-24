package com.example.seu.web.house;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.mapper.HouseMapper;
import com.example.seu.pojo.House;
import com.example.seu.pojo.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.ls.LSException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@RestController
public class HouseHandler {
    @Autowired
    HouseMapper hm;
    @Autowired
    CategoryMapper cm;
    @RequestMapping("/gethouse")
    public void gethouse(HttpServletRequest request,HttpServletResponse response)throws Exception {
        response.setCharacterEncoding("utf-8");
        List<House> allhouse = hm.finall();
        JSONArray ja = new JSONArray();
        for (int i = 0; i < allhouse.size(); i++) {
            ja.add(JSONObject.fromObject(allhouse.get(i).getAll()));
        }
        JSONObject res = new JSONObject();
        res.put("msg", ja.toString());
        response.getWriter().write(res.toString());
    }

    @PostMapping("/uploadimage")
    public String uploadimage(@RequestParam("image[]") List<MultipartFile> multipartFile,@RequestParam("district")String district,@RequestParam("type")String type,@RequestParam("area")String area,@RequestParam("cost")String cost,@RequestParam("layer")String layer,@RequestParam("joint")String joint,@RequestParam("information")String information,@RequestParam("host")String host,@RequestParam("neighborhood")String neighborhood) {
        House hs=new House();
        hs.setArea(area);
        hs.setCost(cost);
        hs.setDistrict(district);
        hs.setHost(host);
        hs.setInformation(information);
        if(joint.equals("合租")) {
            hs.setJoint("true");
        }
        else {
            hs.setJoint("false");
        }
        hs.setLayer(layer);
        hs.setNeighborhood(neighborhood);
        hs.setType(type);
        ArrayList<String> img = new ArrayList<>();
            for (MultipartFile each : multipartFile) {
                String fileName = each.getOriginalFilename();//文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀名

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
                String format = simpleDateFormat.format(new Date());

                String path = "/usr/local/resource/img"; //文件存储位置
                fileName = UUID.randomUUID() + suffixName;//图片名
                String imageUrl = path + "/" + fileName;//图片的url
                File dest = new File(imageUrl);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    each.transferTo(dest);
                    img.add("'http://119.3.176.243/" + fileName + "'");//添加图片地址

                } catch (IOException e) {
                    System.out.println("异常");
                }
            }
        hs.setImg(img.toString());
        hm.insert(hs);
        return "true";

    }
    @PostMapping("/mark")
    public String mark(@RequestParam("username")String username,@RequestParam("id")String id)
    {
        User us=cm.getuser(username);
        StringBuilder list=new StringBuilder(us.getMarked());
        list.deleteCharAt(list.length()-1);
        if(list.length()!=1)
        {
            list.append(","+id+"]");}
        else {
            list.append(id+"]");
        }
        us.setMarked(list.toString());
        cm.Update(us);
        return "true";
    }
    @PostMapping("/getmarked")
    public String getmarked(@RequestParam("username")String username)
    {
        User us=cm.getuser(username);
        return us.getMarked();
    }

    @PostMapping("/deletehouse")
    public String deletehouse(@RequestParam("id")String id)
    {
       Integer realid= Integer.parseInt(id);

       hm.deleteById(realid);
       return "true";
    }
}
