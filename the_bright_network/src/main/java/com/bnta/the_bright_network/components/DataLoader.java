package com.bnta.the_bright_network.components;

import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import com.bnta.the_bright_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChatRoomRepository chatRoomRepository;
    MessageRepository messageRepository;
    SubscriptionRepository subscriptionRepository;
    UserRepository userRepository;

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
    }
}
