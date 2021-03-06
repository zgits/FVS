package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.FocusDao;
import com.four.fvs.dao.UserDao;
import com.four.fvs.dao.VideoDao;
import com.four.fvs.model.User;
import com.four.fvs.model.Video;
import com.four.fvs.service.UserService;
import com.four.fvs.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private FocusDao focusDao;

    @Override
    public User login(String userName, String password) {
        User user = userDao.login(userName, password);
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public boolean ifExist(String userName) {
        return userDao.ifExist(userName) != null;
    }

    @Override
    public boolean register(User user) {
        user.setRoleId(2);
        user.setSex("男");
        user.setIntroduce("这个家伙很懒，什么都没有留下");
        user.setCreateTime(new Date());
        int image = (int) (Math.random() * 8) + 1;
        user.setIcon("/static/resources/image/" + String.valueOf(image) + ".png");
        user.setDel(1);
        return userDao.register(user) > 0;
    }

    @Override
    public boolean editxx(User user) {

        return userDao.editxx(user) > 0;
    }



    @Override
    public User getUserInfo(Integer id) {
        User user = userDao.getUserInfo(id);
        if (user != null)
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
     *
     * @param
     * @return
     */
    public List<User>  getAllUserService() {
        return userDao.getAllUserDao();
    }

    /**
     * @Author: yzh
     * @Date: 2019/6/8 23:09
     * @Description: 用戶信息的管理
     */

    /**
     * 通过id得到某个用戶的信息
     *
     * @param id
     * @return
     */


    public User getUserService(Integer id) {
        User user = userDao.getUserDao(id);
        //判断用户是否存在
        if (user != null)
            //不把密码信息传过去
            user.setPassword("");
        return user;

    }

    /**
     * 遍历所有的用戶Fans信息
     *
     * @param
     * @return
     */
    public List<User>  getFansService(Integer id) {
        return userDao.getFansDao(id);
    }

    /**
     * 遍历所有的用戶关注人信息
     *
     * @param
     * @return
     */
    public List<User>  getFocusService(Integer id) {
        return userDao.getFocusDao(id);
    }



}
