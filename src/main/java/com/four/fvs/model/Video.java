package com.four.fvs.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/21 12:26
 * @Description: 视频实体类
 */
public class Video {

    private Integer id;//id

    private String name;//视频名

    private Integer typeId;//分类id

    private Integer userId;//视频上传人

    //防止显示时间乱码,前端有个tool.js文件，里面可以将时间戳转换为特定格式的字符串
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upTime;//视频上传时间

    private Integer vv;//视频播放量

    private String videoLength;//视频长度

    private Integer collectNumber;//视频收藏数，数据库中无该字段

    private Integer shareNumber;//视频分享数，数据库中无该字段

    private Integer praiseNumber;//点赞数，数据库中无该字段

    private String videoSrc;//视频储存位置

    private String simpleIntroduce;//视频简介

    private Integer status;//视频状态，1、审核中 2、审核通过 3、审核不通过

    private String firstImagePath;//视频封面地址

    private Integer del;//删除标志 1 未删除，2 已删除

    private List<VideoComment> videoCommentList;//视频的评论

    private List<BulletScreen> bulletScreenList;//弹幕集合

    private User user;//用户信息

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", upTime=" + upTime +
                ", vv=" + vv +
                ", collectNumber=" + collectNumber +
                ", shareNumber=" + shareNumber +
                ", praiseNumber=" + praiseNumber +
                ", videoSrc='" + videoSrc + '\'' +
                ", simpleIntroduce='" + simpleIntroduce + '\'' +
                ", status=" + status +
                ", firstImagePath='" + firstImagePath + '\'' +
                ", del=" + del +
                ", videoCommentList=" + videoCommentList +
                ", bulletScreenList=" + bulletScreenList +
                ", user=" + user +
                '}';
    }


    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }


    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }

    public List<BulletScreen> getBulletScreenList() {
        return bulletScreenList;
    }

    public void setBulletScreenList(List<BulletScreen> bulletScreenList) {
        this.bulletScreenList = bulletScreenList;
    }

    public List<VideoComment> getVideoCommentList() {
        return videoCommentList;
    }

    public void setVideoCommentList(List<VideoComment> videoCommentList) {
        this.videoCommentList = videoCommentList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Integer getVv() {
        return vv;
    }

    public void setVv(Integer vv) {
        this.vv = vv;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Integer shareNumber) {
        this.shareNumber = shareNumber;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public String getVideoSrc() {
        return videoSrc;
    }

    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }

    public String getSimpleIntroduce() {
        return simpleIntroduce;
    }

    public void setSimpleIntroduce(String simpleIntroduce) {
        this.simpleIntroduce = simpleIntroduce;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }
}
