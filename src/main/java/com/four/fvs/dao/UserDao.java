package com.four.fvs.dao;

import com.four.fvs.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

}
