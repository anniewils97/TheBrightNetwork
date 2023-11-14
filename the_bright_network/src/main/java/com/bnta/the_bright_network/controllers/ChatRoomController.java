package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.ChatRoom;
import com.bnta.the_bright_network.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/chatrooms")
public class ChatRoomController {

    @Autowired
    ChatRoomService chatRoomService;


    //display a chatroom by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long id){
        Optional<ChatRoom> chatRoom = chatRoomService.findChatRoomById(id);

        if (chatRoom.isPresent()){
            return new ResponseEntity<>(chatRoom.get(), HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

