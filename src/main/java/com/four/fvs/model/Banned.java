package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:48
 * @Description: 有关用户禁言的实体类
 */
public class Banned {

    private Integer id;

    private Integer userId;//被禁言的用户id

    private Date startTime;//禁言开始时间

    private Date endTime;//禁言结束时间

    private Integer days;//禁言天数

    private String reason;//禁言原因

    private Integer del;//删除标志 1 未删除，2 已删除

    @Override
    public String toString() {
        return "Banned{" +
                "id=" + id +
                ", userId=" + userId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days=" + days +
                ", reason='" + reason + '\'' +
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
