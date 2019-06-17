package com.four.fvs.service;

import com.four.fvs.model.Type;
import com.four.fvs.vo.VideoIndexVo;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/6/8 14:04
 * @Description:
 */
public interface TypeService {

    /**
     * 根据分类的id获取名字
     * @param id
     * @return
     */
    public String getTypeName(Integer id);

    /**
     * 获取全部分类
     */
    public List<Type> getAllType();

}
