package com.bnta.the_bright_network.services;


import com.bnta.the_bright_network.models.*;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import com.bnta.the_bright_network.repositories.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageService messageService;


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

        return messageService.convertListMessagesToDTOs(allMessages);
    }


    public List<MessageReplyDTO> filterMessages(List<MessageReplyDTO> messagesToFilter, String keyword){
        return messagesToFilter.stream().filter(message -> message.getMessageContent().toLowerCase().contains(keyword.toLowerCase())).toList();
//        ArrayList<MessageReplyDTO> filteredMessages = new ArrayList<>();
        //                filteredMessages.add(message);
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

    public ChatRoomInputDTO saveChatRoom(ChatRoomInputDTO chatRoomInputDTO){
        //access user ids from the dto
        List<Long> userIds = chatRoomInputDTO.getUserIds();
        //are there are least two users?
        if(userIds == null || userIds.size() < 2){
            throw new IllegalArgumentException("A chatroom must have at least two users.");
        }
        //create a new chatroom w a new name
        ChatRoom chatRoom = new ChatRoom(chatRoomInputDTO.getChatroomName());
        chatRoomRepository.save(chatRoom);
        chatRoomInputDTO.setChatroomId(chatRoom.getId());
        //for loop
        for(Long userId : userIds){
            Optional<User> user = userRepository.findById(userId);
            if (user.isEmpty()){
                throw new IllegalArgumentException(String.format("UserId %s does not exist", userId));
            }
            Subscription subscription = new Subscription(user.get(), chatRoom);
            subscriptionRepository.save(subscription);
        }
//        return chatRoomRepository.save(chatRoom);
        return chatRoomInputDTO;
    }

}
