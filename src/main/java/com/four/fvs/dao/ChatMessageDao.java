package com.four.fvs.dao;

import com.four.fvs.model.ChatMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

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
     * @param regexp 正则表达式字符串
     * @return
     */
    public List<ChatMessage> getChatMessageBox(String regexp);


    /**
     * 根据聊天id删除与某个用户的聊天框
     * @param mesId
     * @return
     */
    public Integer updateChatMessageBox(Integer mesId);


    /**
     * 根据聊天id获取聊天记录
     * @param mesId1 聊天标识，由于是组合而成，所以1_3 和3_1是同一个聊天，所以查询需要传递两个参数
     * @param mesId2 聊天标识
     * @return
     */
    public List<ChatMessage> getChatMessages(@Param("mesId1") String mesId1, @Param("mesId2") String mesId2);


}
