package com.example.seu.pojo;

import net.sf.json.JSONObject;

import java.util.ArrayList;

public class House {
    private  int id;
    //小区
    private  String neighborhood;
    //地区
    private String district;
    //户型
    private String type;
    //面积
    private String area;
    //租金
    private String cost;
    //楼层
    private String layer;
    //合租属性
    private String joint;
    //房屋描述
    private String information;
    //户主
    private String host;
    //房屋图片
    private String img;
    public void setId(int id)
    {
        this.id=id;
    }
    public void setImg(String img)
    {
        this.img=img;
    }
    public void setDistrict(String district){this.district=district;}
    public void setType(String type){this.type=type;}
    public  void setArea(String area){this.area=area;}
    public void setCost(String cost){this.cost=cost;}
    public void setLayer(String layer){this.layer=layer;}
    public void setJoint(String joint){this.joint=joint;}
    public void setInformation(String information){this.information=information;}
    public void setHost(String host){this.host=host;}
    public void setNeighborhood(String neighborhood){this.neighborhood=neighborhood;}
    public int getId(){return  id;}
    public  String getImg(){return img;}
    public String getNeighborhood(){return neighborhood;}
    public  String getDistrict(){return  district;}
    public String getType(){return  type;}
    public String getArea(){return  area;}
    public String getCost(){return  cost;}
    public String getLayer(){return layer;}
    public String getJoint(){return  joint;}
    public String getInformation(){return  information;}
    public String getHost(){return host;}
    public String getAll(){
        JSONObject js=new JSONObject();
        js.put("id",id);
        js.put("neighborhood",neighborhood);
        js.put("district",district);
        js.put("type",type);js.put("area",area);
        js.put("cost",cost);
        js.put("layer",layer);
        js.put("joint",joint);
        js.put("information",information);
        js.put("host",host);
        js.put("img",img);
        return js.toString();
    }
}
