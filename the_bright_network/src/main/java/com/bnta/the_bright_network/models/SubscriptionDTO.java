package com.bnta.the_bright_network.models;

public class SubscriptionDTO {

    private long userid;

    private long chatroomid;

    public SubscriptionDTO(long userid, long chatroomid) {
        this.userid = userid;
        this.chatroomid = chatroomid;
    }

    public SubscriptionDTO() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getChatroomid() {
        return chatroomid;
    }

    public void setChatroomid(long chatroomid) {
        this.chatroomid = chatroomid;
    }
}
