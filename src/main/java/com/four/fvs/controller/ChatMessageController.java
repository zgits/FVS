package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.model.ChatMessage;
import com.four.fvs.service.ChatMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    /**
     * 接收、转发、保存消息
     * @param chatMessage
     */
    @MessageMapping("chat/message")
    public void receiveAndSaveMessage(ChatMessage chatMessage){
        chatMessage.setSendTime(new Date());
        logger.info(chatMessage.getSendId()+" 发送消息给 "+chatMessage.getReceiveId()+":"+chatMessage.getMessage());
        chatMessageService.insertChatMessage(chatMessage);
        messagingTemplate.convertAndSend(SUBSCRIBE_MESSAGE_URI,chatMessage);

    }

}
