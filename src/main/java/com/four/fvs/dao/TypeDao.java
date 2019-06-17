package com.four.fvs.dao;

import com.four.fvs.model.Type;
import com.four.fvs.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取全部分类
     */
    public List<Type> getAllType();

}
