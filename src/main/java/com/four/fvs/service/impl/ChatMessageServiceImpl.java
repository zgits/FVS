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
    public int insertChatMessage(ChatMessage chatMessage) {

//        if(chatMessage.getMesId()==null){
//            String mes = DateUtils.DateToString(new Date());//生成聊天id，以当前日期+发送者id
//            chatMessage.setMesId(Integer.parseInt(mes));
//        }
        chatMessage.setDel(1);

        return chatMessageDao.insertChatMessage(chatMessage);
    }
}
