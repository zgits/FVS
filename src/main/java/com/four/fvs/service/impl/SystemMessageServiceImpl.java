package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.SystemMessageDao;
import com.four.fvs.model.SystemMessage;
import com.four.fvs.service.SystemMessageService;
import com.four.fvs.service.UserService;
import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
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


    @Override
    public Integer insertSystemMessage(SystemMessage systemMessage) {
        return systemMessageDao.insertSystemMessage(systemMessage);
    }


    @Override
    public void sendMes(Integer userId, String content) {
        //声明GoEasy，实现消息推送
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io/publish",
                "BC-ba1fdee766924b6ab8b658f2a2c23645");
        try {
            if (userId != null) {
                String channel = userId.toString();
                goEasy.publish(channel, content, new PublishListener() {
                    @Override
                    public void onSuccess() {
                        System.out.print("消息发布成功。");
                    }

                    @Override
                    public void onFailed(GoEasyError error) {
                        System.out.print("消息发布失败, 错误编码：" + error.getCode() + " 错误信息： " + error.getContent());
                    }
                });
            }
        }catch(Exception e){
           System.out.println("转化失败");
        }
    }
}
