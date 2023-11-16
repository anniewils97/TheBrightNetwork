package com.bnta.the_bright_network.models;

import java.util.List;

public class ChatRoomInputDTO {

    private Long  chatroomId;

    private  String chatroomName;
    private List<Long> userIds;

    public ChatRoomInputDTO(long chatroomId, String name, List<Long> userIds) {
        this.chatroomId = chatroomId;
        this.chatroomName = name;
        this.userIds = userIds;
    }

    public ChatRoomInputDTO() {
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
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
