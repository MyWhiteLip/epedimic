package com.example.seu.pojo;

import net.sf.json.JSONObject;

public class User  {

    private int id;
    private String user;
    private String password;
    private String img;
    private String name;
    private String chatmessagelist;
    private String userlist;
    private String marked;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setImg(String img)
    {
        this.img=img;
    }
    public String getImg(){return  img;}
    public  void setName(String name)
    {
        this.name=name;
    }
    public  String getName()
    {
        return  name;
    }
    public void setChatmessagelist(String chatmessagelist)
    {
        this.chatmessagelist=chatmessagelist;
    }
    public void setUserlist(String userlist)
    {
        this.userlist=userlist;
    }
    public  String getChatmessagelist()
    {
        return chatmessagelist;
    }
    public String getUserlist()
    {
        return  userlist;
    }
    public String getMarked()
    {
        return marked;
    }
    public void setMarked(String marked)
    {
        this.marked=marked;
    }
    public String getall()
    {
        JSONObject js=new JSONObject();
        js.put("username",getUser());
        js.put("img",getImg());
        js.put("name",getName());
        js.put("chatmessagelist",getChatmessagelist());
        js.put("userlist",getUserlist());
        return  js.toString();
    }


}