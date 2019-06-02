package com.four.fvs.dao;

import com.four.fvs.model.CommentReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:03
 * @Description: 评论下的回复
 */
@Repository
public interface CommentReplyDao {


    /**
     * 在评论下回复的数据库接口
     *
     * @param commentReply
     * @return
     */
    public Integer addCommentReply(CommentReply commentReply);

    /**
     * 删除回复
     *
     * @param id
     * @return
     */
    public Integer delCommentReply(@Param("id") Integer id);


    /**
     * 根据评论id得到下面的回复
     *
     * @param commentId
     * @return
     */
    public List<CommentReply> getCommentReply(@Param("commentId") Integer commentId);


    /**
     * 根据userId获取回复信息
     *
     * @param beReplyId
     * @return
     */
    public List<CommentReply> getUserCommentReply(
            @Param("beReplyId") Integer beReplyId,
            @Param("begin") int begin,
            @Param("size") int size);
}
