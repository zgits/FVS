package com.four.fvs.service;

import com.four.fvs.model.ChatMessage;

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
    public int insertChatMessage(ChatMessage chatMessage);
}
