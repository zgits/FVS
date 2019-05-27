package com.four.fvs.service.impl;

import com.four.fvs.dao.UserDao;
import com.four.fvs.model.User;
import com.four.fvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/23 14:45
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String password) {
        return userDao.login(userName, password);
    }

    @Override
    public boolean ifExist(String userName) {
        return userDao.ifExist(userName)!=null;
    }

    @Override
    public boolean register(User user) {
        user.setRoleId(2);
        user.setSex("男");
        user.setIntroduce("这个家伙很懒，什么都没有留下");
        user.setCreateTime(new Date());
        user.setDel(1);
        return userDao.register(user)>0;
    }

    @Override
    public User getUserInfo(Integer id) {
        User user=userDao.getUserInfo(id);
        user.setPassword("");
        return user;
    }
}