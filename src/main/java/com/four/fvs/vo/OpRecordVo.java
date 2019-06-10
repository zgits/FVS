package com.four.fvs.vo;

import com.four.fvs.model.VideoOpRecord;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/6/4 20:20
 * @Description: 点赞的展示到前端的展示类
 */
public class OpRecordVo {

    private String userName;//点赞的用户名

    private Integer userId;//点赞的id

    private String icon;//点赞用户的头像

    private Date time;//点赞的时间

    private Integer commentId;//点赞的评论的id

    private String comment;//点赞的内容


    @Override
    public String toString() {
        return "OpRecordVo{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", icon='" + icon + '\'' +
                ", time=" + time +
                ", commentId=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
