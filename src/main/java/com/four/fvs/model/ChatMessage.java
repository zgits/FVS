package com.four.fvs.model;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:28
 * @Description: 实时聊天实体类
 */
public class ChatMessage {

    private Integer id;//id

    private Integer mesId;//聊天id,系统自动生成，一份聊天就一个标识

    private String message;//消息内容

    private Date sendTime;//消息发送时间

    private Integer receiveId;//消息接受者

    private Integer sendId;//消息发送者

    private Integer msgStatus;//消息发送状态 1、发送成功(默认) 2、发送失败 3、发送中

    private Integer del;//删除标志 1 未删除，2 已删除

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", mesId=" + mesId +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                ", receiveId=" + receiveId +
                ", sendId=" + sendId +
                ", msgStatus=" + msgStatus +
                ", del=" + del +
                '}';
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getMesId() {
        return mesId;
    }

    public void setMesId(Integer mesId) {
        this.mesId = mesId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
