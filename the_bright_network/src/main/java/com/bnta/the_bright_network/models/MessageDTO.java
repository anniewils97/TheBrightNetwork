package com.bnta.the_bright_network.models;

public class MessageDTO {

    private  Long subscriptionId;

    private String messageContent;

    public MessageDTO(Long subscriptionId  , String messageContent) {
        this.subscriptionId = subscriptionId;
        this.messageContent = messageContent;
    }

    public MessageDTO() {
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
} //End
