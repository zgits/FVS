package com.four.fvs.service;

import com.four.fvs.model.VideoComment;

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
}
