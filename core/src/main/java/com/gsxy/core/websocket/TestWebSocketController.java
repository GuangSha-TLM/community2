package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.bo.AdminCheckInStatusInRealTimeBo;
import com.gsxy.core.util.SpringContextUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{id}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);
//    private UserAdminMapper userAdminMapper = SpringContextUtil.getBean(UserAdminMapper.class);
//private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session, @PathParam("id") Long id) throws IOException {
//        sessions.add(session);
        String s = this.serviceFunction(id, session);
//        broadcastMessage(s);
        session.getBasicRemote().sendText(s);
    }

    // 其他方法...
    @OnMessage
    public void onMessage(Long id, Session session) throws IOException {

//        System.out.println(id);
        //实现用户签到信息的实时查看
        String s = this.serviceFunction(id, session);
//        broadcastMessage(s);
        session.getBasicRemote().sendText(s);

    }

    @OnClose
    public void onClose(Session session) {
//        sessions.remove(session);
//        System.out.println(session);
//        System.out.println("连接关闭");
//        System.out.println("WebSocket closed for session: " + session.getId());


    }


    public String serviceFunction(Long id, Session session) throws IOException {
        //转换格式
        String str = userAdminController.adminCheckInStatusInRealTimeLast(id);

        return str;
    }
//    private static void broadcastMessage(String message) {
//        for (Session session : sessions) {
//            if (session.isOpen()) {
//                try {
//                    session.getBasicRemote().sendText(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



//    @OnClose
//    public void onClose(Session session) {
//        // 处理关闭事件
//        System.out.println("WebSocket closed for session: " + session.getId());
//    }

}
