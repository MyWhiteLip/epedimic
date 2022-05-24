package com.example.seu.websocket;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class DefaultHandler implements WebSocketHandler {

    /**
     * 建立连接
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 缓存用户信息: userInfo
    }

    /**
     * 接收消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message.getPayload());
       JSONObject js=new JSONObject();
       js.put("msg","你也好");
        session.sendMessage(new sendmessage(js));
    }

    /**
     * 发生错误
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 清除用户缓存信息
    }

    /**
     * 关闭连接
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 清除用户缓存信息
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

class sendmessage implements WebSocketMessage<String>
{

    JSONObject message;
    public sendmessage(JSONObject message){
        this.message=message;
    };
    @Override
    public String getPayload() {
        return this.message.toString();
    }

    @Override
    public int getPayloadLength() {
        return 0;
    }

    @Override
    public boolean isLast() {
        return false;
    }

}
