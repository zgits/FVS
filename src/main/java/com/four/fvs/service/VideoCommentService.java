package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.model.VideoComment;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.vo.VideoCommentVo;

import java.util.List;

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
    public String givePraise(VideoOpRecord videoOpRecord);


    /**
     * 判断点赞是否存在
     * @param videoOpRecord
     * @return
     */
    public boolean ifPraised(VideoOpRecord videoOpRecord);


    /**
     * 根据评论id获取评论信息
     * @param id
     * @return
     */
    public VideoComment getOneCommentById(Integer id);

    /**
     * @Author: yzh
     * @Date: 2019/6/6 13:55
     * @Description： 评论信息的管理
     * /

    /**
     * 遍历所有评论信息
     * @param
     * @return
     */
    public List<VideoComment> getVideoCommentService();

    /**
     * 删除评论信息
     * @param
     * @return
     */
    public boolean delVideoCommentService(Integer videoCommentId);

    /**
     * 获取视频评论数
     */
   public Integer getCountById(Integer videoId,Integer type);
}
