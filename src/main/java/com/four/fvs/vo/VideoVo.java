package com.four.fvs.vo;

import com.four.fvs.model.Video;

/**
 * @Author: zjf
 * @Date: 2019/6/7 13:39
 * @Description:
 */
public class VideoVo {

    private Integer userId;//用户id

    private String userName;//用户姓名

    private String icon;//用户头像

    private Integer focus;//关注数

    private Video video;//视频信息

    private String type;//分类名字

    @Override
    public String toString() {
        return "VideoVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                ", focus=" + focus +
                ", video=" + video +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getFocus() {
        return focus;
    }

    public void setFocus(Integer focus) {
        this.focus = focus;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
