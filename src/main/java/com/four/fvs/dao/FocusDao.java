package com.four.fvs.dao;

import com.four.fvs.model.Focus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 关注类的数据库相关操作的类
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 15:43.
 */
@Repository
public interface FocusDao {


    /**
     * 得到某个用户的关注数量
     * @param userId
     * @return
     */
    public Integer getCountFocus(Integer userId);


    /**
     * 对某个用户添加关注
     * @param focus
     * @return
     */
    public Integer addFocus(Focus focus);
}
