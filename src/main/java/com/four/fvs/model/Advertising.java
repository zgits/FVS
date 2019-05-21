package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 12:49
 * @Description: 广告表实体类
 */
public class Advertising {

    private Integer id;//id

    private Integer length;//广告时长

    private String info;//广告基本信息

    private Date validTime;//广告有效期

    private String adSrc;//广告视频来源

    @Override
    public String toString() {
        return "Advertising{" +
                "id=" + id +
                ", length=" + length +
                ", info='" + info + '\'' +
                ", validTime=" + validTime +
                ", adSrc='" + adSrc + '\'' +
                '}';
    }

    public String getAdSrc() {
        return adSrc;
    }

    public void setAdSrc(String adSrc) {
        this.adSrc = adSrc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
}
