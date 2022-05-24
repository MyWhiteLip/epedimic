package com.example.seu.websocket;

import org.springframework.web.socket.WebSocketSession;

import javax.mail.Session;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ServerManager {

    public static ConcurrentHashMap<String,WebSocketSession> servers=new ConcurrentHashMap<>();


    public static int getTotal(){
        return servers.size();
    }
    public static void add(String username,WebSocketSession server){
        servers.put(username,server);
        System.out.println("有新连接加入！"+username+" 当前总连接数是："+ servers.size());
    }
    public static void remove(WebSocketSession session){
       Set<String> a= servers.keySet();
       for(String each:a)
       {
           if(servers.get(each)==session)
           {
               servers.remove(each);
           }
       }
        System.out.println("有连接退出！ 当前总连接数是："+ servers.size());
    }
    public static WebSocketSession search(String username)
    {
        return servers.get(username);
    }


}
