package com.four.fvs.dao;

import com.four.fvs.model.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    /**
     * 点赞数量增加
     * @param videoId
     * @param number +1或者-1，根据是否有点赞记录来决定
     * @return
     */
    public Integer givePraise(@Param("id") Integer videoId,@Param("number")Integer number);



    /**
     * 分享数量的增加
     * @param videoId
     * @return
     */
    public Integer giveShare(@Param("id")Integer videoId);


    /**
     * 收藏数量的增加
     * @param videoId
     * @param number +1或者-1，根据是否有收藏记录来决定
     * @return
     */
    public Integer giveCollection(@Param("id")Integer videoId,@Param("number")Integer number);

    /**
     * 获取首页视频
     * @return
     */
    public List<Video> getAllVideo();

}
