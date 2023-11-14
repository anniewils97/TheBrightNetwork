package com.bnta.the_bright_network.models;

public class SubscriptionDTO {

    private long userId;

    private long chatroomId;

    public SubscriptionDTO(long userId, long chatroomId) {
        this.userId = userId;
        this.chatroomId = chatroomId;
    }

    public SubscriptionDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(long chatroomId) {
        this.chatroomId = chatroomId;
    }
}
