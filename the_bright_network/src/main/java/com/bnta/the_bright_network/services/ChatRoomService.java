package com.bnta.the_bright_network.services;


import com.bnta.the_bright_network.models.*;
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

    public List<ChatroomDTO> getAllChatrooms() {
//        finding all the chatrooms in db
        List<ChatRoom> chatrooms = chatRoomRepository.findAll();
//        initialising empty arraylist of chatroomDTOs
        List<ChatroomDTO> chatroomDTOs = new ArrayList<>();
//looping through the chatroom list
        for (ChatRoom chatRoom : chatrooms) {
//             for each chatroom taking id and name
            ChatroomDTO chatroomDTO = new ChatroomDTO(chatRoom.getId(), chatRoom.getName());
//            storing in the arraylist
            chatroomDTOs.add(chatroomDTO);
        }
        return chatroomDTOs;
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
        //Sort messages by timestamp using lambda function
        Collections.sort(allMessages, (b,a)->a.getTimeStamp().compareTo(b.getTimeStamp()));

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

//    Display all users in a specific chosen chatroom
    public List<UserDTO> allUsersInChatroom(long id){
        Optional<ChatRoom> existingChatroom = chatRoomRepository.findById(id); //Looks for the id of the chatroom
        //once chatroom found, look for existing users in the chatroom
        if (existingChatroom.isEmpty()){
            return null;
        }
        //
        List<UserDTO> allUsers = new ArrayList<>();
        for (Subscription subscription: existingChatroom.get().getSubscriptions()){
//            allUsers.add(subscription.getUser());
            User user = subscription.getUser();
            UserDTO userDTO= new UserDTO(user.getId(), user.getName(), user.getAge(),user.getRole());
            allUsers.add(userDTO);
        }
        return allUsers;
    }


//    public List<MessageReplyDTO> messagesToMessageReplyDTO(List<Message> messages){
//
//        return null;
//    }


}
