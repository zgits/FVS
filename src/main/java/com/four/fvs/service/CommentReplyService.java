package com.four.fvs.service;

import com.four.fvs.model.CommentReply;

/**
 * @Author: zjf
 * @Date: 2019/5/25 15:08
 * @Description: 回复的服务接口
 */
public interface CommentReplyService {


    /**
     * 回复的服务接口
     * @param commentReply
     * @return
     */
    public boolean addCommentReply(CommentReply commentReply);


    /**
     * 根据回复的id删除回复
     * @param commentReplyId
     * @return
     */
    public boolean delCommentReply(Integer commentReplyId);
}
