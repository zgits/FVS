package com.four.fvs.service;

import com.four.fvs.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/5/23 21:40
 * @Description:
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void ifExist() {
        System.out.println(userService.ifExist("test"));
    }
}