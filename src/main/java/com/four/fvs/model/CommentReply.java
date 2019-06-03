package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:32
 * @Description: 评论回复表实体类
 */
public class CommentReply {

    private Integer id;//id

    private String content;//回复内容

    private Date replyTime;//回复时间

    private Integer replyId;//回复人的id

    private Integer beReplyId;//被回复人的id

    private Integer commentId;//评论id

    private Integer del;//删除标志 1 未删除，2 已删除


    @Override
    public String toString() {
        return "CommentReply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", replyTime=" + replyTime +
                ", replyId=" + replyId +
                ", beReplyId=" + beReplyId +
                ", commentId=" + commentId +
                ", del=" + del +
                '}';
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getBeReplyId() {
        return beReplyId;
    }

    public void setBeReplyId(Integer beReplyId) {
        this.beReplyId = beReplyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
