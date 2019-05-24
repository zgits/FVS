package com.four.fvs.model;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:01
 * @Description: 关注表实体类
 */
public class Focus {

    private Integer id;//id

    private Integer userId;//用户id

    private Integer fansId;//粉丝id

    //去掉了数据库中的关注者id

    @Override
    public String toString() {
        return "Focus{" +
                "id=" + id +
                ", userId=" + userId +
                ", fansId=" + fansId +
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

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }
}
