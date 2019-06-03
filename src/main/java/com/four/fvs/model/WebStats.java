package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 12:51
 * @Description:
 */
public class WebStats {

    private Integer id;//id

    private Date visitTime;//访问时间

    private Integer userId;//访问用户id

    private Integer del;//删除标志 1 未删除，2 已删除

    @Override
    public String toString() {
        return "WebStats{" +
                "id=" + id +
                ", visitTime=" + visitTime +
                ", userId=" + userId +
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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
