package com.four.fvs.service.impl;

import com.four.fvs.BaseTest;
import com.four.fvs.service.ChatMessageService;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/6/3 23:17
 * @Description:
 */
public class ChatMessageServiceImplTest extends BaseTest {

    @Autowired
    private ChatMessageService chatMessageService;

    @Test
    public void getChatMessageBox() {

        System.out.println(chatMessageService.getChatMessageBox(3).size());

    }
}