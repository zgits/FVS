package com.four.fvs.dao;

import com.four.fvs.model.ChatMessage;
import org.springframework.stereotype.Repository;

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

}
