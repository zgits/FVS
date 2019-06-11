package com.four.fvs.service;

import com.four.fvs.model.User;

import java.util.Date;
import java.util.List;


/**
 * @Author: zjf
 * @Date: 2019/5/23 14:44
 * @Description: 服务实现接口
 */
public interface UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
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

    /**
     * @Author: yzh
     * @Date: 2019/6/8 17:56
     * @Description: 用户信息的管理
     */

    /**
     * 遍历所有的用户信息
     * @param
     * @return
     */

    public List<User> getAllUserService();

    /**
     * @Author: yzh
     * @Date: 2019/6/8 23:06
     * @Description: 用户信息的管理
     */

    /**
     * 通过用户id得到某个用户的信息
     * @param id
     * @return
     */

    public User getUserService(Integer id);

    /**
     * 通过用户id禁言某个用户
     * @param id
     * @return
     */
//    public User banUserService(Integer id,String startTime, String endTime,Integer days,String reason);
    public  boolean banUserService(Integer id);

}

