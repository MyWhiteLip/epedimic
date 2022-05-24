package com.example.seu.websocket;

import com.example.seu.mapper.CategoryMapper;
import com.example.seu.pojo.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import com.example.seu.web.HelloController;
import javax.crypto.MacSpi;
import javax.servlet.http.HttpServletRequest;

@Component
public class ChatHandler implements WebSocketHandler {

   @Autowired
   CategoryMapper cm;
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
    public void handleMessage( WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        JSONObject js=JSONObject.fromObject(message.getPayload().toString());
        System.out.println(js);
        if(js.get("my")==null)
        {
           ServerManager.add(js.get("username").toString(),session);
            return;
        }
        String my=js.get("my").toString();
        String user=js.get("user").toString();
        String msg=js.get("msg").toString();
        JSONObject res=new JSONObject();
        res.put("user",my);
        res.put("msg",msg);
        //
        User user1=cm.getuser(my);User user2=cm.getuser(user);
        JSONArray ja1chat=JSONArray.fromObject(user1.getChatmessagelist());
        JSONArray ja2chat=JSONArray.fromObject(user2.getChatmessagelist());
        if(!isexisted(user1,user2))
        {

            if(!isexisteduser(user1,user2))
            {
                JSONArray ja1= JSONArray.fromObject(user1.getUserlist());
                JSONObject jo1=new JSONObject();
                jo1.put("username",user2.getUser());
                jo1.put("name",user2.getName());
                jo1.put("img",user2.getImg());
                ja1.add(jo1);
                user1.setUserlist(ja1.toString());
                cm.Update(user1);
                JSONArray ja2= JSONArray.fromObject(user2.getUserlist());
                JSONObject jo2=new JSONObject();
                jo2.put("username",user1.getUser());
                jo2.put("name",user1.getName());
                jo2.put("img",user1.getImg());
                ja2.add(jo2);
                user2.setUserlist(ja2.toString());
                cm.Update(user2);
            }
            //
            JSONObject chat1=new JSONObject();
            JSONObject detail1=new JSONObject();
            detail1.put("type","my");
            detail1.put("msg",msg);
            JSONArray list1=new JSONArray();list1.add(detail1);
            chat1.put("username",user2.getUser());
            chat1.put("list",list1);
            ja1chat.add(chat1);
            user1.setChatmessagelist(ja1chat.toString());
            cm.Update(user1);
            //
            JSONObject chat2=new JSONObject();
            JSONObject detail2=new JSONObject();
            detail2.put("type","user");
            detail2.put("msg",msg);
            JSONArray list2=new JSONArray();list2.add(detail2);
            chat2.put("username",user1.getUser());
            chat2.put("list",list2);
            ja2chat.add(chat2);
            user2.setChatmessagelist(ja2chat.toString());
            cm.Update(user2);
        }
        else
        {
            for(int i=0;i<ja1chat.size();i++)
            {
                if(ja1chat.getJSONObject(i).get("username").equals(user2.getUser()))
                {
                    JSONArray ja=ja1chat.getJSONObject(i).getJSONArray("list");
                    JSONObject detail1=new JSONObject();
                    detail1.put("type","my");
                    detail1.put("msg",msg);
                    ja.add(detail1);
                    ja1chat.getJSONObject(i).put("list",ja);
                    user1.setChatmessagelist(ja1chat.toString());
                    cm.Update(user1);
                }
            }
            for(int i=0;i<ja2chat.size();i++)
            {
                if(ja2chat.getJSONObject(i).get("username").equals(user1.getUser()))
                {
                    JSONArray ja=ja2chat.getJSONObject(i).getJSONArray("list");
                    JSONObject detail2=new JSONObject();
                    detail2.put("type","user");
                    detail2.put("msg",msg);
                    ja.add(detail2);
                    ja2chat.getJSONObject(i).put("list",ja);
                    user2.setChatmessagelist(ja2chat.toString());
                    cm.Update(user2);
                }
            }


        }
        send(user,new TextMessage(res.toString()));


    }

    public Boolean isexisteduser(User user1,User user2){
        JSONArray jauserlist1= JSONArray.fromObject(user1.getUserlist());
        for(int i=0;i<jauserlist1.size();i++)
        {
            if(jauserlist1.getJSONObject(i).get("username").equals(user2.getUser()))
            {
               return true;
            }
        }
        return false;
    }
    public boolean isexisted(User user1,User user2)
    {
        JSONArray jauserlist1= JSONArray.fromObject(user1.getUserlist());
        JSONArray chatlist=JSONArray.fromObject(user1.getChatmessagelist());
        boolean flag1=false;
        boolean flag2=false;
        for(int i=0;i<jauserlist1.size();i++)
        {
            if(jauserlist1.getJSONObject(i).get("username").equals(user2.getUser()))
            {
                flag1=true;
            }
        }
        for(int i=0;i<chatlist.size();i++)
        {
            if(chatlist.getJSONObject(i).get("username").equals(user2.getUser()))
            {
                flag2=true;
            }
        }
        return flag1&&flag2;
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
        ServerManager.remove(session);
        // 清除用户缓存信息
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void send(String username,TextMessage text)throws Exception
    {
        if(ServerManager.search(username)!=null)
        {
            System.out.println(username);
            WebSocketSession wss=ServerManager.search(username);
            wss.sendMessage(text);
        }
    }
}
