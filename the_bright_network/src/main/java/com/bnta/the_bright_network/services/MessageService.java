package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageDTO;
import com.bnta.the_bright_network.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;


    //Save a message in the db
    public void saveMessage(MessageDTO messageDTO){
        Message message = new Message(
                messageDTO.getMessageContent(),
                messageDTO.getSubscription(),
                LocalDateTime.now());
        messageRepository.save(message);
    }





} //Last curly bracket
