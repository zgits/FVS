package com.four.fvs.model;

/**
 * @Author: zjf
 * @Date: 2019/5/25 21:38
 * @Description: 用户有关视频或者番剧的操作记录，点赞，分享，对评论的点赞
 */
public class VideoOpRecord {

    private Integer id;//id

    private Integer userId;//操作的用户id

    private Integer recordId;//操作对象的id，视频，评论，番剧

    private Integer type;//操作对象类型，1 视频，2 番剧 3 评论（因为评论也有点赞的功能）

    private Integer opType;//操作类型 1 点赞 2 分享 3 收藏

    private Integer del=1;//删除标志 1 未删除，2 已删除

    @Override
    public String toString() {
        return "VideoOpRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", recordId=" + recordId +
                ", type=" + type +
                ", opType=" + opType +
                ", del=" + del +
                '}';
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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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
