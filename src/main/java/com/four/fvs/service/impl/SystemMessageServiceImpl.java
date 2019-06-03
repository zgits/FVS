package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.SystemMessageDao;
import com.four.fvs.model.SystemMessage;
import com.four.fvs.service.SystemMessageService;
import com.four.fvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/23 23:10
 * @Description:
 */
@Service
public class SystemMessageServiceImpl implements SystemMessageService {

    @Autowired
    private SystemMessageDao systemMessageDao;

    @Autowired
    private UserService userService;


    /**
     * 基本想法，
     * 由于是下拉加载数据，根据前端传递的当前页数，即每次自动加1
     *
     * @param currPage
     * @param receiveId 用户id
     * @return
     */
    @Override
    public PageBean<SystemMessage> getHistorySystemMessage(int currPage, int receiveId) {

        Date createTime = userService.getUserInfo(receiveId).getCreateTime();

        Integer size = 0;
        Integer begin = 0;
        if (currPage == 1) {
            size = 20;
        } else if (currPage == 2) {
            /**
             * 第二次下拉加载时，直接开始设置为20，
             */
            begin = 20;
            size = 10;
        } else {
            size = 10;
            begin = (currPage - 1) * size;
        }


        PageBean<SystemMessage> result = new PageBean<>();

        result.setCurrPage(currPage);

        result.setLists(systemMessageDao.getHistorySystemMessage(begin, size, receiveId, createTime));

        return result;
    }
}
