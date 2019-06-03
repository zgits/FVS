package com.four.fvs.service.impl;

import com.four.fvs.BaseTest;
import com.four.fvs.model.SystemMessage;
import com.four.fvs.service.SystemMessageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/6/1 16:05
 * @Description:
 */
public class SystemMessageServiceImplTest extends BaseTest {

    @Autowired
    private SystemMessageService systemMessageService;
    @Test
    public void getHistorySystemMessage() {

        System.out.println(systemMessageService.getHistorySystemMessage(1,4));
    }
}