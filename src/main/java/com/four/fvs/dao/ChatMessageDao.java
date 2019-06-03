package com.four.fvs.dao;

import com.four.fvs.model.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/22 11:21
 * @Description: 实时聊天的数据库接口
 */
@Repository
public interface ChatMessageDao {

    /**
     * 保存聊天记录数据库接口
     * @param chatMessage
     * @return 影响的行数
     */
    public Integer insertChatMessage(ChatMessage chatMessage);


    /**
     * 根据用户id得到未被删除的聊天框
     * @param userId
     * @return
     */
    public List<ChatMessage> getChatMessageBox(Integer userId);


    /**
     * 根据聊天id删除与某个用户的聊天框
     * @param mesId
     * @return
     */
    public Integer updateChatMessageBox(Integer mesId);


    /**
     * 根据聊天id获取聊天记录
     * @param mesId
     * @return
     */
    public List<ChatMessage> getChatMessages(Integer mesId);


}
