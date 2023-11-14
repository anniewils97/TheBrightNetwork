package com.bnta.the_bright_network.services;


import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageReplyDTO;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Optional<ChatRoom> findChatRoomById(Long id){
        return chatRoomRepository.findById(id);
    }
  
      public List<ChatRoom> getAllChatrooms(){
        return chatRoomRepository.findAll();
    }


    public List<MessageReplyDTO> getOrderedMessages(long id) {
        //get all the subscriptions in a given chatroom
        List<Subscription> subscriptions = subscriptionRepository.findByChatRoomId(id);
        //get messages from each subscription inside a given chatroom
        List<Message> allMessages = new ArrayList<>();
        for (Subscription subscription : subscriptions){
            List<Message> subscriptionMessages = subscription.getMessages();
            allMessages.addAll(subscriptionMessages);
        }

        Collections.sort(allMessages, (a,b)->a.getTimeStamp().compareTo(b.getTimeStamp()));
        Collections.reverse(allMessages);

        ArrayList<MessageReplyDTO> orderedMessages = new ArrayList<>();
      
        for (Message message: allMessages) {
            MessageReplyDTO messageDTO = new MessageReplyDTO(
                    message.getId(),
                    message.getSubscription().getUser().getName(),
                    message.getMessageContent(),
                    message.getTimeStamp().toString()
            );
            orderedMessages.add(messageDTO);
        }

        return orderedMessages;
    }


//    public List<MessageReplyDTO> messagesToMessageReplyDTO(List<Message> messages){
//
//        return null;
//    }


}
