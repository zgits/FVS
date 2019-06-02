package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.model.CommentReply;
import com.four.fvs.vo.CommentReplyVo;

import java.util.List;

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


    /**
     * 根据评论id得到回复
     * @param commentId
     * @return
     */
    public List<CommentReply> getCommentReply(Integer commentId);


    /**
     * 前端采用下拉式加载，根据页数加载
     * @param currPage
     * @param beReplyId
     * @return
     */
    public PageBean<CommentReplyVo> getUserCommentReply(Integer currPage,Integer beReplyId);
}
