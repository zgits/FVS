package com.four.fvs.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/21 14:48
 * @Description: 番剧的实体类
 */
public class HisPlay {

    private Integer id;//id

    private String name;//番剧名称

    private Integer playNumber;//播放量

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;//番剧上架时间

    private String introduce;//描述

    private Integer status;//状态，1、更新中 2、已下架 3、已完结

    private Integer del;//删除标志 1 未删除，2 已删除


    private List<VideoForHisPlay> videoForHisPlayList;//该番剧对应的集数

    @Override
    public String toString() {
        return "HisPlay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playNumber=" + playNumber +
                ", introduce='" + introduce + '\'' +
                ", status=" + status +
                ", del=" + del +
                ", videoForHisPlayList=" + videoForHisPlayList +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(Integer playNumber) {
        this.playNumber = playNumber;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VideoForHisPlay> getVideoForHisPlayList() {
        return videoForHisPlayList;
    }

    public void setVideoForHisPlayList(List<VideoForHisPlay> videoForHisPlayList) {
        this.videoForHisPlayList = videoForHisPlayList;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
