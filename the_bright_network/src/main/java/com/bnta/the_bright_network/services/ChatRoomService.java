package com.bnta.the_bright_network.services;


import com.bnta.the_bright_network.models.*;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  
    public List<ChatRoomDTO> getAllChatrooms() {
//        finding all the chatrooms in db
        List<ChatRoom> chatrooms = chatRoomRepository.findAll();
//        initialising empty arraylist of chatroomDTOs
        List<ChatRoomDTO> chatroomDTOs = new ArrayList<>();
//looping through the chatroom list
        for (ChatRoom chatRoom : chatrooms) {
//             for each chatroom taking id and name
            ChatRoomDTO chatroomDTO = new ChatRoomDTO(chatRoom.getId(), chatRoom.getName());
//            storing in the arraylist
            chatroomDTOs.add(chatroomDTO);
        }
        return chatroomDTOs;
    }

    public List<MessageReplyDTO> getOrderedMessages(long id, MessageDTO messageDTO) {

        List<Subscription> chatRoomSubscriptions = subscriptionRepository.findByChatRoomIdAndUserId(id, messageDTO.getuserId());
        if (chatRoomSubscriptions.isEmpty()){
            return null;
        }

        //get all the subscriptions in a given chatroom
        List<Subscription> subscriptions = subscriptionRepository.findByChatRoomId(id);
        //get messages from each subscription inside a given chatroom
        List<Message> allMessages = new ArrayList<>();
        for (Subscription subscription : subscriptions){
            List<Message> subscriptionMessages = subscription.getMessages();
            allMessages.addAll(subscriptionMessages);
        }
        //Sort messages by timestamp using lambda function
        Collections.sort(allMessages, (b,a)->a.getTimeStamp().compareTo(b.getTimeStamp()));

        ArrayList<MessageReplyDTO> orderedMessages = new ArrayList<>();
      
        for (Message message: allMessages) {
            MessageReplyDTO messageReplyDTO = new MessageReplyDTO(
                    message.getId(),
                    message.getSubscription().getUser().getName(),
                    message.getMessageContent(),
                    message.getTimeStamp().toString()
            );
            orderedMessages.add(messageReplyDTO);
        }

        return orderedMessages;
    }


//    public List<MessageReplyDTO> messagesToMessageReplyDTO(List<Message> messages){
//
//        return null;
//    }


}
