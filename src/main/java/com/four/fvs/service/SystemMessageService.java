package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.model.SystemMessage;
import org.springframework.stereotype.Service;

/**
 * @Author: zjf
 * @Date: 2019/5/23 23:08
 * @Description: 系统通知服务接口
 */
@Service
public interface SystemMessageService {


    /**
     * 分页获得历史通知消息,前端采用下拉加载，获得数据通过分页
     * @param currPage
     * @param size
     * @param receiveId
     * @return
     */
    PageBean<SystemMessage> getHistorySystemMessage(int currPage,Integer size,int receiveId);
}
