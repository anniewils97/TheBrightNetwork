package com.bnta.the_bright_network.services;


import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.repositories.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    public Optional<ChatRoom> findChatRoomById(Long id){
        return chatRoomRepository.findById(id);
    }
}
