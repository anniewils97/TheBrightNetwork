package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.models.SubscriptionDTO;
import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

//    adding a new user to the chatroom
    @Transactional
    public Subscription addNewUserToChatroom(long chatroomId, long userId){
        Subscription chatroom = subscriptionRepository.findById(chatroomId).get();
         Subscription subscription = subscriptionRepository.findById(userId).get();
        User user = subscription.getUser();
         chatroom.setUser(user);
         subscriptionRepository.save(chatroom);
         return subscription;



    }



} //Last curly bracket
