package com.four.fvs.service.impl;

import com.four.fvs.dao.UserDao;
import com.four.fvs.model.User;
import com.four.fvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        User user=userDao.login(userName, password);
        if(user!=null){
            user.setPassword("");
        }
        return user;
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
        int image= (int) (Math.random()*8)+1;
        user.setIcon("/static/resources/image/"+String.valueOf(image)+".png");
        user.setDel(1);
        return userDao.register(user)>0;
    }

    @Override
    public User getUserInfo(Integer id) {
        User user=userDao.getUserInfo(id);
        if(user!=null)
        user.setPassword("");
        return user;
    }

    /**
     * @Author: yzh
     * @Date: 2019/6/8 18:01
     * @Description: 用戶信息的管理
     */

    /**
     * 遍历所有的用戶信息
     * @param
     * @return
     */
    public List<User> getAllUserService(){
        return userDao.getAllUserDao();
    }

}
