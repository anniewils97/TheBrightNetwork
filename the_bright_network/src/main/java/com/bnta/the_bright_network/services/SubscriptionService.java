package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.models.SubscriptionDTO;
import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import com.bnta.the_bright_network.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRoomRepository chatRoomRepository;

//    adding a new user to the chatroom
    @Transactional
    public Subscription addNewUserToChatroom(SubscriptionDTO subscriptionDTO){
        User user =  userRepository.findById(subscriptionDTO.getUserId()).get();
        ChatRoom chatRoom = chatRoomRepository.findById(subscriptionDTO.getChatroomId()).get();
        Subscription subscription = new Subscription(user, chatRoom);
        subscriptionRepository.save(subscription);
        return subscription;

    }

    public List<Subscription> displayAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

} //Last curly bracket
