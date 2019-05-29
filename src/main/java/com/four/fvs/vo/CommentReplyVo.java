package com.four.fvs.vo;

import com.four.fvs.model.CommentReply;

/**
 * @Description: 传递到前端的视频回复信息,包含回复信息和用户信息
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/5/27 20:29.
 */
public class CommentReplyVo {
    private CommentReply commentReply;

    private Integer userId;//回复者用户的id

    private String userName;//回复者用户姓名

    private String icon;//回复者用户头像

    private Integer beUserId;//被回复者的id

    private String beUserName;//被回复用户姓名

    private String beIcon;//被回复者用户头像

    @Override
    public String toString() {
        return "CommentReplyVo{" +
                "commentReply=" + commentReply +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                ", beUserId=" + beUserId +
                ", beUserName='" + beUserName + '\'' +
                ", beIcon='" + beIcon + '\'' +
                '}';
    }

    public CommentReply getCommentReply() {
        return commentReply;
    }

    public void setCommentReply(CommentReply commentReply) {
        this.commentReply = commentReply;
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

    public Integer getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(Integer beUserId) {
        this.beUserId = beUserId;
    }

    public String getBeUserName() {
        return beUserName;
    }

    public void setBeUserName(String beUserName) {
        this.beUserName = beUserName;
    }

    public String getBeIcon() {
        return beIcon;
    }

    public void setBeIcon(String beIcon) {
        this.beIcon = beIcon;
    }
}
