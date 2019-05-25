package com.four.fvs.dao;

import com.four.fvs.model.VideoComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:04
 * @Description: 视频评论数据库接口
 */
@Repository
public interface VideoCommentDao {


    /**
     * 插入评论
     * @param videoComment
     * @return
     */
    public Integer insert(VideoComment videoComment);


    /**
     * 分页查询视频下的评论
     * @param videoId
     * @param begin
     * @param size
     * @return
     */
    public List<VideoComment> getVideoComment(@Param("videoId") Integer videoId,
                                              @Param("begin") Integer begin,
                                              @Param("size") Integer size,
                                              @Param("type") Integer type);


    /**
     * 获得某个视频或番剧下的评论数量
     * @param videoId
     * @param type
     * @return
     */
    public Integer getCount(@Param("videoId") Integer videoId,@Param("type") Integer type);


    /**
     * 删除某条评论
     * @param id
     * @return
     */
    public Integer delComment(@Param("id")Integer id);

//
//    /**
//     * 由于字段缺失，暂不填写参数
//     * @return
//     */
//    public Integer praise();


}
