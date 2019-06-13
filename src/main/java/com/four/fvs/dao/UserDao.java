package com.four.fvs.dao;

import com.four.fvs.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/21 16:30
 * @Description: 用户的相关数据库接口
 */
@Repository
public interface UserDao {




    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName")String userName,@Param("password")String password);


    /**
     * 用户注册
     * @param user
     * @return
     */
    public Integer register(User user);

    /**
     * 用户修改个人信息
     * @param user
     * @return
     */
    public Integer editxx(User user);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    public User ifExist(@Param("userName")String userName);

    /**
     * 根据用户id得到用户信息
     * @param id
     * @return
     */
    public User getUserInfo(@Param("id") Integer id);


    /**
     * @Author: yzh
     * @Date: 2019/6/8 18:04
     * @Description: 用戶信息的管理
     */

    /**
     * 遍历所有的用戶信息
     * @param
     * @return
     */
    public List<User> getAllUserDao();

    /**
     * @Author: yzh
     * @Date: 2019/6/8 23:16
     * @Description: 用戶信息的管理
     */

    /**
     * 通过id得到某个用戶的信息
     * @param id
     * @return
     */
    public User getUserDao(@Param("id") Integer id);

    /**
     * 通过id得到某个用戶的信息
     * @param id
     * @return
     */
    public List<User> getFansDao(@Param("id") Integer id);
    public List<User> getFocusDao(@Param("id") Integer id);
}
