package com.four.fvs.vo;

import com.four.fvs.model.ChatMessage;

import java.util.List;

/**
 * @Description: 实际传递到前端的消息记录信息实体类
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 19:38.
 */
public class ChatMessageVo {

    private List<ChatMessage> chatMessages;//消息实体类

    private Integer sendId;//回复者用户的id

    private String userName;//回复者用户姓名

    private String icon;//回复者用户头像

    private Integer receiveId;//被回复者的id

    private String receiveName;//被回复用户姓名

    private String receiveIcon;//被回复者用户头像

    @Override
    public String toString() {
        return "ChatMessageVo{" +
                "chatMessages=" + chatMessages +
                ", sendId=" + sendId +
                ", userName='" + userName + '\'' +
                ", icon='" + icon + '\'' +
                ", receiveId=" + receiveId +
                ", receiveName='" + receiveName + '\'' +
                ", receiveIcon='" + receiveIcon + '\'' +
                '}';
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
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

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveIcon() {
        return receiveIcon;
    }

    public void setReceiveIcon(String receiveIcon) {
        this.receiveIcon = receiveIcon;
    }
}
