package com.four.fvs.service.impl;

import com.four.fvs.dao.ChatMessageDao;
import com.four.fvs.model.ChatMessage;
import com.four.fvs.model.User;
import com.four.fvs.service.ChatMessageService;
import com.four.fvs.service.UserService;
import com.four.fvs.utils.DateUtils;
import com.four.fvs.vo.ChatMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/22 12:47
 * @Description:
 */
@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageDao chatMessageDao;

    @Autowired
    private UserService userService;

    @Override
    public ChatMessageVo insertChatMessage(ChatMessage chatMessage) {

        chatMessage.setSendTime(new Date());
        chatMessage.setDel(1);
        chatMessage.setReceiveChatStatus(1);
        chatMessage.setSendChatStatus(1);
        String msgId=String.valueOf(chatMessage.getSendId())+"_"+String.valueOf(chatMessage.getReceiveId());

        chatMessage.setMesId(msgId);

        chatMessageDao.insertChatMessage(chatMessage);

        ChatMessageVo chatMessageVo=new ChatMessageVo();

        List<ChatMessage> chatMessages=new ArrayList<>();
        chatMessages.add(chatMessage);
        chatMessageVo.setChatMessages(chatMessages);

        User user1=userService.getUserInfo(chatMessage.getSendId());//得到发送者的用户基本信息

        User user2=userService.getUserInfo(chatMessage.getReceiveId());//得到接收者的用户基本信息

        //设置发送者的基本信息
        chatMessageVo.setIcon(user1.getIcon());

        chatMessageVo.setSendId(user1.getId());

        chatMessageVo.setUserName(user1.getUserName());


        //设置接收者基本信息
        chatMessageVo.setReceiveIcon(user2.getIcon());

        chatMessageVo.setReceiveId(user2.getId());

        chatMessageVo.setReceiveName(user2.getUserName());

        return chatMessageVo;
    }

    @Override
    public List<ChatMessage> getChatMessageBox(Integer userId) {
        return chatMessageDao.getChatMessageBox(userId);
    }

    @Override
    public boolean updateChatMessageBox(Integer mesId) {
        return chatMessageDao.updateChatMessageBox(mesId)>0;
    }

    @Override
    public ChatMessageVo getChatMessages(String mesId) {
        String[] ids=mesId.split("_");
        System.out.println(ids[0]);

        String mesId1=ids[0]+"_"+ids[1];
        String mesId2=ids[1]+"_"+ids[0];

        User user1=userService.getUserInfo(Integer.valueOf(ids[0]));//得到发送者的用户基本信息

        User user2=userService.getUserInfo(Integer.valueOf(ids[1]));//得到接收者的用户基本信息

        List<ChatMessage> chatMessages=chatMessageDao.getChatMessages(mesId1,mesId2);


        ChatMessageVo chatMessageVo=new ChatMessageVo();

        chatMessageVo.setChatMessages(chatMessages);


        //设置发送者的基本信息
        chatMessageVo.setIcon(user1.getIcon());

        chatMessageVo.setSendId(user1.getId());

        chatMessageVo.setUserName(user1.getUserName());


        //设置接收者基本信息
        chatMessageVo.setReceiveIcon(user2.getIcon());

        chatMessageVo.setReceiveId(user2.getId());

        chatMessageVo.setReceiveName(user2.getUserName());

        return chatMessageVo;
    }
}
