package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.*;
import com.bnta.the_bright_network.services.ChatRoomService;
import com.bnta.the_bright_network.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chatrooms")
public class ChatRoomController {

    @Autowired
    ChatRoomService chatRoomService;
    @Autowired
    MessageService messageService;

    //Creating a message in the chatroom
    @PostMapping (value = "/{id}/messages")
    public ResponseEntity<Message> addNewMessage(@PathVariable Long id, @RequestBody MessageDTO messageDTO){
        try {
            Message message = messageService.saveMessage(id, messageDTO);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping
    public  ResponseEntity<List<ChatRoomDTO>> getAllChatrooms(){
        List<ChatRoomDTO> chatRooms = chatRoomService.getAllChatrooms();
        return new ResponseEntity<>(chatRooms, HttpStatus.OK);
    }

    //display a chatroom by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long id){
        Optional<ChatRoom> chatRoom = chatRoomService.findChatRoomById(id);

        if (chatRoom.isPresent()){
            return new ResponseEntity<>(chatRoom.get(), HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/messages")
    public ResponseEntity <List<MessageReplyDTO>> getAllMessagesInOrder(@PathVariable long id, @RequestBody MessageDTO messageDTO){
        List<MessageReplyDTO> orderedMessages = chatRoomService.getOrderedMessages(id, messageDTO);
        return new ResponseEntity<>(orderedMessages, orderedMessages==null?HttpStatus.FORBIDDEN:HttpStatus.OK);
    }

}//end