package com.four.fvs.dao;

import com.four.fvs.model.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:30
 * @Description: 普通视频的数据库接口
 */
@Repository
public interface VideoDao {

    /**
     * 用户播放视频时，根据视频id获取视频数据
     * @param id
     * @return
     */
    public Video getOneVideoById(@Param("id") Integer id);
}
