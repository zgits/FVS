package com.four.fvs.model;

import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/21 12:44
 * @Description: 视频评论表实体类
 */
public class VideoComment {

    private Integer id;//id

    private String content;//评论内容

    private Date createTime;//发表时间

    private Integer userId;//评论人id

    private Integer videoId;//所评论的视频id

    private Integer praiseNumber;//该条评论点赞数,数据库中无该字段

    private Integer type;//评论的类型，1、对于普通视频 2、对于番剧的评论

    private Integer del;//删除标志 1 未删除，2 已删除

    private List<CommentReply> commentReplyList;//评论回复的集合

    private User user;   //调用的用户信息

    @Override
    public String toString() {
        return "VideoComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", praiseNumber=" + praiseNumber +
                ", type=" + type +
                ", del=" + del +
                ", commentReplyList=" + commentReplyList +
                '}';
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public List<CommentReply> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(List<CommentReply> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
