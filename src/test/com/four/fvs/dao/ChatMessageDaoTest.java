package com.four.fvs.dao;

import com.four.fvs.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/6/3 10:42
 * @Description:
 */
public class ChatMessageDaoTest extends BaseTest {

    @Autowired
    private ChatMessageDao chatMessageDao;


    @Test
    public void getChatMessageBox() {

        System.out.println(chatMessageDao.getChatMessageBox(1));

    }
}