package com.springboot.websocket.ws.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * websocket 服务端
 *
 * @author 三多
 * @Time 2020/4/13
 */
@ServerEndpoint("/user/{userId}")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger onLineCount = new AtomicInteger(0);
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 接收userId
     */
    private String userId;

    /**
     * 连接建立成功调用的方法
     * 1、存储会话、上下文userId
     * 2、在线人数+1
     * 3、通知客户端链接成功
     *
     * @param session 会话
     * @param userId  用户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        //1、存储会话、上下文userId
        this.session = session;
        this.userId = userId;
        if (webSocketMap.containsKey(userId)) {
            //加入set
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
        } else {
            webSocketMap.put(userId, this);
            // 2、在线人数+1
            addOnlineCount();
        }
        //3、通知客户端链接成功
        try {
            sendMessage("链接成功");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("用户:" + userId + ",网络异常!!!!!!");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * 解析处理
     *
     * @param message 客户端发送过来的消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息:" + userId + ",报文:" + message);
        //可以群发消息
        //消息保存到数据库、redis
        if (!StringUtils.isEmpty(message)) {
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId", this.userId);
                //获取发送目标
                String toUserId = jsonObject.getString("toUserId");
                if (StringUtils.isNotBlank(toUserId) && webSocketMap.containsKey(toUserId)) {
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                } else {
                    //否则不在这个服务器上，发送到mysql或者redis
                    log.error("请求的userId:" + toUserId + "不在该服务器上");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 连接关闭调用的方法
     * 1、注销session
     * 2、在线人数-1
     */
    @OnClose
    public void onClose() {
        //1、注销session
        if (webSocketMap.containsKey(userId)) {
            //删除
            webSocketMap.remove(userId);
            //2、在线人数-1
            subOnlineCount();
        }
        log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());


    }

    /**
     * 异常
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("用户错误:" + this.userId + ",原因:" + throwable.getMessage());
        throwable.printStackTrace();

    }

    /**
     * 发送消息
     *      存储数据库
     *      给前端发送数据
     *          调接口
     * @param message 消息
     * @param userId  userId
     */
    public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
        log.info("发送消息到:" + userId + "，报文:" + message);
        if (StringUtils.isNotBlank(userId) && webSocketMap.containsKey(userId)) {
            webSocketMap.get(userId).sendMessage(message);
        } else {
            log.error("用户" + userId + ",不在线！");
        }
    }

    /**
     * 阻塞
     * 实现服务器主动推送
     *
     * @param message 消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 获取在线人数
     *
     * @return
     */
    public static synchronized Integer getOnlineCount() {
        return onLineCount.intValue();
    }

    /**
     * 在线人数添加
     *
     * @return
     */
    public static synchronized AtomicInteger addOnlineCount() {

        return getAndSet(1);
    }

    /**
     * 在线人数消减
     *
     * @return
     */
    public static synchronized AtomicInteger subOnlineCount() {
        return getAndSet(-1);
    }

    public static AtomicInteger getAndSet(Integer value) {
        int currentCount = WebSocketServer.onLineCount.addAndGet(value);
        AtomicInteger result = new AtomicInteger(currentCount);
        return result;
    }

 /*   public static void main(String[] args) {
        System.out.println("onLineCount: "+onLineCount);
        System.out.println("+1: "+getAndSet(1));
        System.out.println("-1: "+getAndSet(-1));
    }*/
}
