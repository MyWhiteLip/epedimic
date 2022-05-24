package com.example.seu.web.chat;

import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@CrossOrigin(origins = "http://localhost:8081",maxAge = 36000)
@ServerEndpoint(value="/ws/{fromId}",configurator = SpringConfigurator.class)
public class chatserver {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    public String fromId;


    @OnOpen
    public void onOpen(@PathParam("fromId") String fromId, Session session){
        this.session = session;
        this.fromId=fromId;
        System.out.println("连接");
            ServerManager.add(this);
}

    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose(){
        ServerManager.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

}