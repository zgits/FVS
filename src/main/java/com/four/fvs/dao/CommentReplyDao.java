package com.four.fvs.dao;

import com.four.fvs.model.CommentReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:03
 * @Description: 评论下的回复
 *
 */
@Repository
public interface CommentReplyDao {


    /**
     * 在评论下回复的数据库接口
     * @param commentReply
     * @return
     */
    public Integer addCommentReply(CommentReply commentReply);

    /**
     * 删除回复
     * @param id
     * @return
     */
    public Integer delCommentReply(@Param("id") Integer id);


    public List<CommentReply> getCommentReply(@Param("commentId") Integer commentId);
}
