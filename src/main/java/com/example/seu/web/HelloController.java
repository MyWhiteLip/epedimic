package com.example.seu.web;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Random;

import com.example.seu.entity.AreaId;
import com.example.seu.service.AreaIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @Resource
    AreaIdService ais;
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
    @GetMapping("/testarea")
    @ResponseBody
    public int test(@RequestParam("area")String area)
    {
        System.out.println(area);
       return ais.searchAreaIdByArea(area);
    }
    @RequestMapping("/add")
    public String geta()
    {
        File file = new File("C:\\Users\\22962\\Documents\\Tencent Files\\2296271570\\FileRecv\\ChineseAdminiID.xls");//文件流
        //读Excel
        try {
            Workbook workbook =  Workbook.getWorkbook(file);
            //3. 获取指定的sheet页码   通过指定的Sheet页的名字获取指定的Sheet页，也可以通过索引获取Sheet
            Sheet sheet = workbook.getSheet(0);//Sheet sheet = workbook.getSheet("表格1");
            //4.循环获取每行每列的单元格内容
            for (int i = 0; i < sheet.getRows(); i++) {//行
                AreaId ai=new AreaId();
                for (int j = 0; j < sheet.getColumns(); j++) {//列
                    Cell cell = sheet.getCell(j,i);//这里注意，是(j,i)
                    if(j==0){
                    ai.setAreaId(Integer.parseInt(cell.getContents()));
                    }
                    else
                    {
                        ai.setArea(cell.getContents());
                        ais.addAreaId(ai);
                    }
                }
                System.out.println();               //设置每查询完一行就换行
            }
            workbook.close();    //将工作簿的资源关闭
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return "yes";

    }


}
