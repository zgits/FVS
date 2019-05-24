package com.four.fvs.service;

import com.four.fvs.model.User;

/**
 * @Author: zjf
 * @Date: 2019/5/23 14:44
 * @Description: 服务实现接口
 */
public interface UserService {

    public User login(String userName,String password);


    /**
     * 判断用户名是否存在
     * @param userName
     * @return
     */
    public boolean ifExist(String userName);


    /**
     * 注册是否成功
     * @param user
     * @return
     */
    public boolean register(User user);


    /**
     * 根据用户id得到用户信息
     * @param id
     * @return
     */
    public User getUserInfo(Integer id);
}
