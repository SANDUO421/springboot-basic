package com.springboot.websocket.controller;

import com.springboot.websocket.domain.User;
import com.springboot.websocket.service.IUserService;
import com.springboot.websocket.ws.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * websocket 测试controller
 * @author 三多
 * @Time 2020/4/13
 */
@RestController
@RequestMapping("/demo")
public class WebSocketController {
     @Autowired
     private IUserService service;

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }
    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }
    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        //查询数据库
        User user = service.findMessage(Integer.valueOf(toUserId));
        //WebSocketServer.sendInfo(message,toUserId);
        WebSocketServer.sendInfo(user.toString(),toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

}
