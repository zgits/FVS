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


    /**
     * 评论的点赞操作
     * @param commentId
     * @param number
     * @return
     */
    public Integer givePraise(@Param("id") Integer commentId,@Param("number")Integer number);



    /**
     * 根据id获取评论
     * @param id
     * @return
     */
    public VideoComment getOneVideoCommentById(Integer id);



    /**
     * @Author: yzh
     * @Date: 2019/6/6 13:31
     * @Description： 评论信息的管理
     * /

     /**
     * 遍历所有评论信息
     * @param
     * @return
     */
    public List<VideoComment> getVideoCommentDao();

    /**
     * 删除某条评论
     * @param
     * @return
     */
    public Integer delVideoCommentDao(@Param("id")Integer videoCommentId);

}
