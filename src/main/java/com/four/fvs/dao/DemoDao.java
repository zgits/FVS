package com.four.fvs.dao;

import com.four.fvs.model.Demo;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/5/13 23:00
 * @Description: 演示dao
 */
@Repository
public interface DemoDao {


    public Integer insert(Demo demo);
}
