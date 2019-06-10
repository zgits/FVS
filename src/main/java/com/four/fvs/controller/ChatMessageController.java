package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.ChatMessage;
import com.four.fvs.model.User;
import com.four.fvs.service.ChatMessageService;
import com.four.fvs.service.UserService;
import com.four.fvs.vo.ChatMessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
     * 接收、保存、转发消息
     * @param message
     */
    @MessageMapping("/chat/message")
    public void receiveMessage(ChatMessage message){

        //保存聊天信息
        ChatMessageVo chatMessageVo =chatMessageService.insertChatMessage(message);


        messagingTemplate.convertAndSendToUser(chatMessageVo.getReceiveId().toString(),"/chat/message",chatMessageVo);
       // messagingTemplate.convertAndSend(SUBSCRIBE_MESSAGE_URI, message);

    }


    @GetMapping("/chat/getMessageBox")
    @ResponseBody
    public Result<Object> getChatMessageBox(Integer userId){
        return ResultUtils.success(chatMessageService.getChatMessageBox(userId));
    }


    @DeleteMapping("/chat/delMessageBox")
    @ResponseBody
    public Result<Object> delChatMessageBox(Integer mesId){
        return ResultUtils.success(chatMessageService.updateChatMessageBox(mesId));
    }


    @GetMapping("/chat/getMessages")
    @ResponseBody
    public Result<Object> getChatMessages(String mesId){
        return ResultUtils.success(chatMessageService.getChatMessages(mesId));
    }


}
