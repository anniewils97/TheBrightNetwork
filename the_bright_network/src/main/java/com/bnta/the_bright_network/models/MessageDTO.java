package com.bnta.the_bright_network.models;

public class MessageDTO {

    private  Subscription subscription;

    private String messageContent;

    public MessageDTO( Subscription subscription, String messageContent) {
        this.subscription = subscription;
        this.messageContent = messageContent;
    }

    public MessageDTO() {
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
