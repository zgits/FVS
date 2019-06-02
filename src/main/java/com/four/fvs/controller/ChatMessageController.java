package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.model.ChatMessage;
import com.four.fvs.model.User;
import com.four.fvs.service.ChatMessageService;
import com.four.fvs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.WebSocketSession;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 22:03
 * @Description: 实时聊天
 */
@Controller
public class ChatMessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SUBSCRIBE_MESSAGE_URI = "/topic/chat/message"; //订阅接收消息地址

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private UserService userService;

    /**
     * 接收并且转发消息
     * @param message
     */
    @MessageMapping("/chat/message")
    public void receiveMessage(ChatMessage message){

        //获得发送者用户信息
        User user=userService.getUserInfo(message.getSendId());

        //获得接收者用户信息
        User user1=userService.getUserInfo(message.getReceiveId());


        logger.info(message.getSendTime() + "," + user.getUserName() + "发送消息给" + user1.getUserName()+":"+message.getMessage());
        //保存聊天信息
        message=chatMessageService.insertChatMessage(message);


        messagingTemplate.convertAndSendToUser(user1.getId().toString(),"/chat/message",message);
       // messagingTemplate.convertAndSend(SUBSCRIBE_MESSAGE_URI, message);


    }



}
