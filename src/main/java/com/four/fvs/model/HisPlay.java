package com.four.fvs.model;

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

    private String introduce;//描述

    private Integer status;//状态，1、更新中 2、已下架 3、已完结

    private List<VideoForHisPlay> videoForHisPlayList;//该番剧对应的集数

    @Override
    public String toString() {
        return "HisPlay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playNumber=" + playNumber +
                ", introduce='" + introduce + '\'' +
                ", status=" + status +
                ", videoForHisPlayList=" + videoForHisPlayList +
                '}';
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
}
