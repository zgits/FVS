package com.four.fvs.dao;

import com.four.fvs.BaseTest;
import com.four.fvs.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/5/21 16:33
 * @Description:
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        User user=new User();
        user.setPassword("1111");
        user.setUserName("test");
        user.setCreateTime(new Date());
        user.setIcon("test0000");
        user.setIntroduce("sdf");
        user.setRoleId(2);
        user.setSex("男");
        System.out.println(userDao.register(user));
        //System.out.println(userDao.ifExist("test"));


    }
}