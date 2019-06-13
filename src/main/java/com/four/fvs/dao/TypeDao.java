package com.four.fvs.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/6/8 14:00
 * @Description:
 */
@Repository
public interface TypeDao {

    /**
     * 根据id获取分类的名字
     * @param id
     * @return
     */
    public String getTypeName(Integer id);
}
