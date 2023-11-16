package com.bnta.the_bright_network.models;

import java.util.List;

public class ChatRoomDTO {

    private Long  chatroomId;

    private  String chatroomName;

    public ChatRoomDTO(long chatroomId, String name) {
        this.chatroomId = chatroomId;
        this.chatroomName = name;
    }

    public ChatRoomDTO() {
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
