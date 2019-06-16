package com.four.fvs.vo;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/20 22:46
 * @Description: 用户实体类
 */
public class UserVo {

    private Integer id;//用户id

    private String userName;// 用户名称

    private String password;//用户密码

    private String icon;//用户头像路径

    private String sex;//用户性别，默认为女

    private String introduce;//自我介绍

    private Date createTime;//创建账号时间

    private Integer roleId;//默认为2，普通用户。2.普通用户 3.VIP 4.管理员

    private Integer del;//删除标志 1 未删除，2 已删除

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getVideocount() {
        return videocount;
    }

    public void setVideocount(Integer videocount) {
        this.videocount = videocount;
    }

    private Integer fans;//粉丝数量

    private Integer videocount;//投稿数量

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", createTime=" + createTime +
                ", roleId=" + roleId +
                ", del=" + del +
                ", fans=" + fans +
                ", videocount=" + videocount +
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
