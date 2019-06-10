package com.four.fvs.model;

import org.springframework.web.socket.WebSocketMessage;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:28
 * @Description: 实时聊天实体类
 */
public class ChatMessage {

    private Integer id;//id

    private String mesId;//聊天id,系统自动生成，两位用户之间以“sendId_receiveId"生成聊天标识

    private String message;//消息内容

    private Date sendTime;//消息发送时间

    private Integer receiveId;//消息接受者

    private Integer sendId;//消息发送者

    private Integer sendChatStatus;//发送者聊天框的状态，是已关闭还是未关闭 1 未关闭 2 已关闭

    private Integer receiveChatStatus;//接收者聊天框的状态，是已关闭还是未关闭 1 未关闭 2 已关闭

    private Integer del;//删除标志 1 未删除，2 已删除

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return getReceiveId().equals(that.getReceiveId()) &&
                getSendId().equals(that.getSendId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiveId(), getSendId());
    }

    public ChatMessage() {
    }

    public ChatMessage(Integer id, String mesId, String message, Date sendTime, Integer receiveId, Integer sendId, Integer sendChatStatus, Integer receiveChatStatus, Integer del) {
        this.id = id;
        this.mesId = mesId;
        this.message = message;
        this.sendTime = sendTime;
        this.receiveId = receiveId;
        this.sendId = sendId;
        this.sendChatStatus = sendChatStatus;
        this.receiveChatStatus = receiveChatStatus;
        this.del = del;
    }


    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", mesId=" + mesId +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                ", receiveId=" + receiveId +
                ", sendId=" + sendId +
                ", sendChatStatus=" + sendChatStatus +
                ", receiveChatStatus=" + receiveChatStatus +
                ", del=" + del +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesId() {
        return mesId;
    }

    public void setMesId(String mesId) {
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

    public Integer getSendChatStatus() {
        return sendChatStatus;
    }

    public void setSendChatStatus(Integer sendChatStatus) {
        this.sendChatStatus = sendChatStatus;
    }

    public Integer getReceiveChatStatus() {
        return receiveChatStatus;
    }

    public void setReceiveChatStatus(Integer receiveChatStatus) {
        this.receiveChatStatus = receiveChatStatus;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
