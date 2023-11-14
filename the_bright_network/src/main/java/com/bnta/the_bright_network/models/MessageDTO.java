package com.bnta.the_bright_network.models;

public class MessageDTO {

    private long id;

    private  Subscription subscription;

    private String messageContent;

    public MessageDTO(long id, Subscription subscription, String messageContent) {
        this.id = id;
        this.subscription = subscription;
        this.messageContent = messageContent;
    }

    public MessageDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
