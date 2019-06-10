package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/25 21:38
 * @Description: 用户有关视频或者番剧的操作记录，点赞，分享，对评论的点赞
 */
public class VideoOpRecord {

    private Integer id;//id

    private Integer userId;//操作的用户id

    private Integer type;//操作对象类型，1 视频，2 番剧 3 评论（因为评论也有点赞的功能）

    private Integer opType;//操作类型 1 点赞 2 分享 3 收藏

    private Date time;//操作的时间

    private Integer del = 1;//删除标志 1 未删除，2 已删除

    private Integer commentId;//点赞评论的id

    private Integer videoId;//点赞视频的id

    private Integer hisplayId;//点赞番剧的id

    private Integer beUserId;//被操作对象人的id


    @Override
    public String toString() {
        return "VideoOpRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", opType=" + opType +
                ", time=" + time +
                ", del=" + del +
                ", commentId=" + commentId +
                ", videoId=" + videoId +
                ", hisplayId=" + hisplayId +
                ", beUserId=" + beUserId +
                '}';
    }

    public Integer getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(Integer beUserId) {
        this.beUserId = beUserId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getHisplayId() {
        return hisplayId;
    }

    public void setHisplayId(Integer hisplayId) {
        this.hisplayId = hisplayId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
