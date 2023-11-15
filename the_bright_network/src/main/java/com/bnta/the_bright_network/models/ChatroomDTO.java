package com.bnta.the_bright_network.models;

public class ChatroomDTO {

    private Long  chatroomId;

    private  String chatroomName;

    public ChatroomDTO(long chatroomId, String name) {
        this.chatroomId = chatroomId;
        this.chatroomName = name;
    }

    public ChatroomDTO() {
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public String getChatroomName() {
        return chatroomName;
    }

    public void setChatroomName(String chatroomName) {
        this.chatroomName = chatroomName;
    }
}
