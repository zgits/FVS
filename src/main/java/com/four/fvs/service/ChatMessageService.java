package com.four.fvs.service;

import com.four.fvs.model.ChatMessage;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/22 12:45
 * @Description: 实时聊天服务接口
 */
public interface ChatMessageService {

    /**
     * 保存聊天记录服务接口
     * 生成聊天id
     * @param chatMessage
     * @return
     */
    public ChatMessage insertChatMessage(ChatMessage chatMessage);


    /**
     * 查询聊天窗口
     * @param userId
     * @return
     */
    public List<ChatMessage> getChatMessageBox(Integer userId);


    /**
     * 删除某个聊天窗口
     * @param mesId
     * @return
     */
    public boolean updateChatMessageBox(Integer mesId);


    /**
     * 根据聊天id获取聊天记录
     * @param mesId
     * @return
     */
    public List<ChatMessage> getChatMessages(Integer mesId);
}
