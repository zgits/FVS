package com.four.fvs.dao;

import com.four.fvs.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/5/21 16:30
 * @Description: test
 */
@Repository
public interface UserDao {

    public void insert(User user);

}
