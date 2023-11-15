package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageDTO;
import com.bnta.the_bright_network.models.MessageReplyDTO;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;


    //Save a message in the db
    public Message saveMessage(Long chatRoomId, MessageDTO messageDTO) throws Exception {

        List<Subscription> optionalSubscription = subscriptionRepository.findByChatRoomIdAndUserId(chatRoomId, messageDTO.getuserId()); //findById(messageDTO.getSubscriptionId());
        if (optionalSubscription.isEmpty()){
            throw new Exception("this subscription does not exist");
        }

        Message message = new Message(
                messageDTO.getMessageContent(),
                optionalSubscription.get(0),
                LocalDateTime.now());
        messageRepository.save(message);
        return message;
    }

    @Transactional
    public Message updateMessage(MessageReplyDTO messageReplyDTO, long id){
        Message messageToUpdate = messageRepository.findById(id).get();
        messageToUpdate.setMessageContent(messageReplyDTO.getMessageContent());
//        messageToUpdate.setTimeStamp(messageReplyDTO.getTimeStamp());
        messageRepository.save(messageToUpdate);
        return messageToUpdate;
    }






} //Last curly bracket
