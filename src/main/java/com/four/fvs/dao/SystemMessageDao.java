package com.four.fvs.dao;

import com.four.fvs.model.SystemMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/23 22:37
 * @Description: 系统通知数据库接口
 */
@Repository
public interface SystemMessageDao {

    /**
     * 分页查询系统通知
     *
     * @param begin 开始位置
     * @param size 每页大小
     * @param receiveId 用户id
     * @param createTime 用户账号的创建时间
     * @return
     */
    public List<SystemMessage> getHistorySystemMessage(
            @Param("begin") int begin,
            @Param("size") int size,
            @Param("receiveId") int receiveId,
            @Param("createTime")Date createTime);


    /**
     * 系统通知消息录入
     *
     * @param systemMessage
     * @return
     */
    Integer insertSystemMessage(SystemMessage systemMessage);


    /**
     * 删除消息
     *
     * @param id 消息id
     * @return
     */
    Integer deleteMessage(@Param("id") Integer id);


    /**
     * 历史消息
     *
     * @return
     */
    List<SystemMessage> listMessages();

    /**
     * 获取消息条数
     *
     * @return 返回消息条数
     */
    Integer countMessage();
}
