package com.four.fvs.dao;

import com.four.fvs.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/5/23 22:57
 * @Description:
 */
public class SystemMessageDaoTest extends BaseTest {

    @Autowired
    private SystemMessageDao systemMessageDao;
    @Test
    public void getHistorySystemMessage() {
        System.out.println(systemMessageDao.getHistorySystemMessage(0,5,1,new Date()));
    }
}