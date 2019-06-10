package com.four.fvs.vo;

import com.four.fvs.model.User;
import com.four.fvs.model.VideoComment;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 11:49
 * @Description: 传递到前端的视频评论的真正值,包含评论信息和用户信息
 */
public class VideoCommentVo {

    private VideoComment videoComment;

    //用户相关信息
    private Integer userId;//用户id

    private String userName;//用户姓名

    private String icon;//用户头像

    private Integer replyNumber;//回复数量

    private List<CommentReplyVo> commentReplyVos;

    @Override
    public String toString() {
        return "VideoCommentVo{" +
                "videoComment=" + videoComment +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                ", replyNumber=" + replyNumber +
                ", commentReplyVos=" + commentReplyVos +
                '}';
    }

    public List<CommentReplyVo> getCommentReplyVos() {
        return commentReplyVos;
    }

    public void setCommentReplyVos(List<CommentReplyVo> commentReplyVos) {
        this.commentReplyVos = commentReplyVos;
    }

    public Integer getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(Integer replyNumber) {
        this.replyNumber = replyNumber;
    }

    public VideoComment getVideoComment() {
        return videoComment;
    }

    public void setVideoComment(VideoComment videoComment) {
        this.videoComment = videoComment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
