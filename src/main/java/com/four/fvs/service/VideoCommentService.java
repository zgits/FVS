package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.model.VideoComment;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.vo.VideoCommentVo;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:18
 * @Description:
 */
public interface VideoCommentService {


    /**
     * 用户评论某个视频
     * @param videoComment
     * @return
     */
    public Integer addComment(VideoComment videoComment);


    /**
     * 分页查询视频下的评论
     * @param currPage
     * @param videoId
     * @param type
     * @return
     */
    public PageBean<VideoCommentVo> getCommentByPage(Integer currPage, Integer videoId, Integer type);


    /**
     * 根据评论id删除评论
     * @param commentId
     * @return
     */
    public boolean delComment(Integer commentId);


    /**
     * 对评论的点赞
     * @param videoOpRecord
     * @return
     */
    public boolean givePraise(VideoOpRecord videoOpRecord);


    /**
     * 根据评论id获取评论信息
     * @param id
     * @return
     */
    public VideoComment getOneCommentById(Integer id);
}
