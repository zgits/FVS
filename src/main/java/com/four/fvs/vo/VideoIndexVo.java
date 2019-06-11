package com.four.fvs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.four.fvs.model.BulletScreen;
import com.four.fvs.model.User;
import com.four.fvs.model.VideoComment;

import java.util.Date;
import java.util.List;

public class VideoIndexVo {
    private Integer id;//id

    private String name;//视频名

    private Integer typeId;//分类id
    //防止显示时间乱码,前端有个tool.js文件，里面可以将时间戳转换为特定格式的字符串
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upTime;//视频上传时间

    private Integer vv;//视频播放量

    private String videoLength;//视频长度

    private String videoSrc;//视频储存位置

    private String firstImagePath;//视频封面地址

    private Integer del;//删除标志 1 未删除，2 已删除

    private List<VideoComment> videoCommentList;//视频的评论

    private  Integer CommentCount;//视频评论数


    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", upTime=" + upTime +
                ", vv=" + vv +
                ", videoSrc='" + videoSrc + '\'' +
                ", firstImagePath='" + firstImagePath + '\'' +
                ", del=" + del +
                ", videoCommentList=" + videoCommentList +
                ", CommentCount="+CommentCount+
                '}';
    }

    public Integer getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Integer commentCount) {
        CommentCount = commentCount;
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

    public List<VideoComment> getVideoCommentList() {
        return videoCommentList;
    }

    public void setVideoCommentList(List<VideoComment> videoCommentList) {
        this.videoCommentList = videoCommentList;
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

    public String getVideoSrc() {
        return videoSrc;
    }

    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }
}
