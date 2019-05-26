package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/20 23:00
 * @Description: 弹幕实体类
 */
public class BulletScreen {

    private Integer id;//id

    private String color;//颜色代码 #FFD302

    private Integer position;//弹幕位置，1.滚动 2.顶部 3.底部

    private Integer size;//弹幕大小 1.正常大小 2. 小

    private String text;//弹幕内容

    private Date bulletTime;//弹幕发送时间

    private Integer videoId;//对应的视频id

    private Integer del;//删除标志 1 未删除，2 已删除


    @Override
    public String toString() {
        return "BulletScreen{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", position=" + position +
                ", size=" + size +
                ", text='" + text + '\'' +
                ", bulletTime=" + bulletTime +
                ", videoId=" + videoId +
                ", del=" + del +
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
