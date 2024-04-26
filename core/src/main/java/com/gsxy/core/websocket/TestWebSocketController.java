package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.pojo.bo.TokenBo;
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
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        sessions.add(session);
        String s = this.serviceFunction(token, session);
        broadcastMessage(s);
        session.getBasicRemote().sendText(s);
    }

    @OnMessage
    public void onMessage(String token, Session session) throws IOException {
        String s = this.serviceFunction(token, session);
        session.getBasicRemote().sendText(s);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("WebSocket closed for session: " + session.getId());
    }

    public String serviceFunction(String token, Session session) throws IOException {
        return userAdminController.querySignInUser(new TokenBo(token));
    }

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

