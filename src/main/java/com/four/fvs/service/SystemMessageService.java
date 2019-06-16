package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.model.SystemMessage;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/23 23:08
 * @Description: 系统通知服务接口
 */
public interface SystemMessageService {


    /**
     * 分页获得历史通知消息,前端采用下拉加载，获得数据通过分页,用户版
     * @param currPage
     * @param receiveId
     * @return
     */
    PageBean<SystemMessage> getHistorySystemMessage(int currPage,int receiveId);

    /**
     * 插入数据
     *
     * @param systemMessage
     * @return
     */
    Integer insertSystemMessage(SystemMessage systemMessage);


    /**
     * 根据用户ID来发送消息
     *
     * @param userId 用户ID
     * @param content 消息内容
     */
    void sendMes( Integer userId, String content);

    /**
     * 删除消息
     *
     * @param id 消息id
     * @return
     */
    Integer deleteMessage(Integer id);

    /**
     * 查看历史消息
     *
     * @return 历史集合
     */
    List<SystemMessage> listMessages();

}
