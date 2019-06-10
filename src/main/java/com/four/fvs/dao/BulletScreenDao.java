package com.four.fvs.dao;

import com.four.fvs.model.BulletScreen;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 17:36
 * @Description:
 */
@Repository
public interface BulletScreenDao {

    /**
     * 插入弹幕
     * @param bulletScreen
     * @return
     */
    public Integer addBulletScreen(BulletScreen bulletScreen);


    public List<BulletScreen> getBulletScreen(@Param("videoId") Integer videoId, @Param("type") Integer type);
}
