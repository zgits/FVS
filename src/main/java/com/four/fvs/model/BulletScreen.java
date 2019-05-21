package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/20 23:00
 * @Description: 弹幕实体类
 */
public class BulletScreen {

    private Integer id;//id

    private String color;//颜色

    private String position;//弹幕位置，默认在上,注：数据库中为int

    private Integer size;//弹幕大小

    private String text;//弹幕内容

    private Date bulletTime;//弹幕发送时间

    private Integer videoId;//对应的视频id

    @Override
    public String toString() {
        return "BulletScreen{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", position='" + position + '\'' +
                ", size=" + size +
                ", text='" + text + '\'' +
                ", bulletTime=" + bulletTime +
                ", videoId=" + videoId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getBulletTime() {
        return bulletTime;
    }

    public void setBulletTime(Date bulletTime) {
        this.bulletTime = bulletTime;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
