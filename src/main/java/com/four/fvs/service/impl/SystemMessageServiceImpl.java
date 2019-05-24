package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.SystemMessageDao;
import com.four.fvs.model.SystemMessage;
import com.four.fvs.service.SystemMessageService;
import com.four.fvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/23 23:10
 * @Description:
 */
public class SystemMessageServiceImpl implements SystemMessageService {

    @Autowired
    private SystemMessageDao systemMessageDao;

    @Autowired
    private UserService userService;


    @Override
    public PageBean<SystemMessage> getHistorySystemMessage(int currPage, Integer size, int receiveId) {

        Date createTime=userService.getUserInfo(receiveId).getCreateTime();

        Integer begin=(currPage-1)*size;

        PageBean<SystemMessage> result=new PageBean<>();

        result.setLists(systemMessageDao.getHistorySystemMessage(begin,size,receiveId,createTime));

        return result;
    }
}
