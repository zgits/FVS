package com.four.fvs.service.impl;

import com.four.fvs.dao.ChatMessageDao;
import com.four.fvs.model.ChatMessage;
import com.four.fvs.service.ChatMessageService;
import com.four.fvs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/22 12:47
 * @Description:
 */
@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageDao chatMessageDao;

    @Override
    public ChatMessage insertChatMessage(ChatMessage chatMessage) {

        chatMessage.setSendTime(new Date());
        chatMessage.setDel(1);
        chatMessage.setReceiveChatStatus(1);
        chatMessage.setSendChatStatus(1);
        String msgId=String.valueOf(chatMessage.getSendId())+"_"+String.valueOf(chatMessage.getReceiveId());

        chatMessage.setMesId(msgId);

        chatMessageDao.insertChatMessage(chatMessage);

        return chatMessage;
    }
}
