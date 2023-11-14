package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageDTO;
// import com.bnta.the_bright_network.services.ChatRoomService;
import com.bnta.the_bright_network.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat_rooms")
public class ChatRoomController {

//    @Autowired
//    ChatRoomService chatRoomService;

    @Autowired
    MessageService messageService;

    //Creating a message in the chatroom
    @PostMapping
    public ResponseEntity<Message> addNewMessage(@RequestBody MessageDTO messageDTO){
        try {
            Message message = messageService.saveMessage(messageDTO);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }



} // Last curly bracket
