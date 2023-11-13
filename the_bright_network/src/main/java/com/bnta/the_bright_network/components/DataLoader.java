package com.bnta.the_bright_network.components;

import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import com.bnta.the_bright_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {



    @Autowired
    ChatRoomRepository chatRoomRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Rayster", 25, "Student");
        User user2 = new User("Sarah", 23, "Student");
        User user3 = new User("Faiz", 23, "Student");
        User user4 = new User("Annie", 26, "Student");
        User user5 = new User("Zsolt", 34, "Trainer");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        ChatRoom chatroom1 = new ChatRoom (" cohort 12 chatroom");
        ChatRoom chatroom2 = new ChatRoom (" cohort 11 chatroom");
        ChatRoom chatroom3 = new ChatRoom (" cohort 7 chatroom");
        ChatRoom chatroom4 = new ChatRoom (" cohort 3 chatroom");

        chatRoomRepository.save(chatroom1);
        chatRoomRepository.save(chatroom2);
        chatRoomRepository.save(chatroom3);
        chatRoomRepository.save(chatroom4);

        Subscription subscription1 = new Subscription(user1,chatroom1);
        Subscription subscription2 = new Subscription(user2,chatroom2);
        Subscription subscription3 = new Subscription(user3,chatroom4);
        Subscription subscription4 = new Subscription(user2,chatroom1);

        subscriptionRepository.save(subscription1);
        subscriptionRepository.save(subscription2);
        subscriptionRepository.save(subscription3);
        subscriptionRepository.save(subscription4);

        Message message1 = new Message("I'm Sarah !", subscription1,LocalDateTime.now());
        Message message2 = new Message("Hi, everyone", subscription1,LocalDateTime.now());
        Message message3 = new Message("Welcome !", subscription1,LocalDateTime.now());
        Message message4 = new Message("Hi, Rayster!", subscription1,LocalDateTime.now());

        messageRepository.save(message1);
        messageRepository.save(message2);
        messageRepository.save(message3);
        messageRepository.save(message4);
    }

}
