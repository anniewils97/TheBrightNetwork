package com.bnta.the_bright_network.models;

public class SubscriptionDTO {

    private long subscriptionId;
    private long userId;

    private long chatroomId;

    public SubscriptionDTO(long subscriptionId, long userId, long chatroomId) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.chatroomId = chatroomId;
    }

    public SubscriptionDTO() {
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
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
