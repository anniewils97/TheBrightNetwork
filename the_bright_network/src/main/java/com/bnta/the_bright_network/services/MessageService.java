package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageDTO;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;


    //Save a message in the db
    public Message saveMessage(MessageDTO messageDTO) throws Exception
    {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(messageDTO.getSubscriptionId());
        if (optionalSubscription.isEmpty()){
            throw new Exception("this subscription does not exist");
        }

        Message message = new Message(
                messageDTO.getMessageContent(),
                optionalSubscription.get(),
                LocalDateTime.now());
        messageRepository.save(message);
        return message;
    }

    //






} //Last curly bracket
