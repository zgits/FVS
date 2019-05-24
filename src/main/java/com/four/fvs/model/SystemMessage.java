package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:15
 * @Description: 系统消息实体类
 */
public class SystemMessage {

    private Integer id;//id

    private String content;//消息内容

    private Integer sendType;//消息类型 1.单发 2.群发 数据库为varchar

    private Date sendTime;//消息发送时间

    private Integer receiveId;//消息接受者，如果消息类型为1，填写接受者，为2不填写

    @Override
    public String toString() {
        return "SystemMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sendType=" + sendType +
                ", sendTime=" + sendTime +
                ", receiveId=" + receiveId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }
}
