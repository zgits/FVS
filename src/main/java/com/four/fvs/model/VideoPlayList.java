package com.four.fvs.model;

import java.util.Date;

/**
 * @Author ljt
 * @Date 2019/5/29
 * @Description 视频播放记录
 */

public class VideoPlayList {

    private Integer id; //自增id

    private Integer videoId; // 视频或番剧id

    private Date watchTime;  //观看时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Date watchTime) {
        this.watchTime = watchTime;
    }
}
