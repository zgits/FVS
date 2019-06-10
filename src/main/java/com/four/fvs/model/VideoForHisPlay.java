package com.four.fvs.model;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/21 15:00
 * @Description: 番剧视频
 */
public class VideoForHisPlay {

    private Integer id;//id

    private Integer hisPlayId;//所属的番剧id

    private String path;//视频地址

    private String name;//该集的名字

    private Integer sort;//该集对应的集数，系统自动生成

    private Integer commentNumber;//评论数

    private String firstImagePath;//番剧封面地址

    private Integer del;//删除标志 1 未删除，2 已删除


    private List<VideoComment> videoCommentList;//该集评论数集合

    @Override
    public String toString() {
        return "VideoForHisPlay{" +
                "id=" + id +
                ", hisPlayId=" + hisPlayId +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", commentNumber=" + commentNumber +
                ", firstImagePath='" + firstImagePath + '\'' +
                ", del=" + del +
                ", videoCommentList=" + videoCommentList +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHisPlayId() {
        return hisPlayId;
    }

    public void setHisPlayId(Integer hisPlayId) {
        this.hisPlayId = hisPlayId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public List<VideoComment> getVideoCommentList() {
        return videoCommentList;
    }

    public void setVideoCommentList(List<VideoComment> videoCommentList) {
        this.videoCommentList = videoCommentList;
    }
}
