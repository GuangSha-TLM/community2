package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.util.SpringContextUtil;
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

    // 依赖注入
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("id") Long id) throws IOException {
        sessions.add(session);
        String s = this.serviceFunction(id, session);
        // 若不需要广播，则可以移除以下两行
//        broadcastMessage(s);
//        session.getBasicRemote().sendText(s);
    }

    @OnMessage
    public void onMessage(@PathParam("id") Long id, Session session) throws IOException {
        // 注意：在WebSocket中，通常不会有额外的@PathParam注解用于OnMessage方法，
        // 因为在WebSocket通信中，一般通过消息体来传递数据，而非路径参数。
        // 若要按需处理消息，可能需要重新设计消息格式和处理逻辑。
        String s = this.serviceFunction(id, session);
        session.getBasicRemote().sendText(s);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("WebSocket closed for session: " + session.getId());
    }

    public String serviceFunction(Long id, Session session) throws IOException {
        return userAdminController.querySignInUser(id);
    }

    // 如果确实需要广播功能，保留此方法
    private static void broadcastMessage(String message) {
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
