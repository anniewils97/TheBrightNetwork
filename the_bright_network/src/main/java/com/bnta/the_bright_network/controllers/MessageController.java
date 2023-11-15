package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageReplyDTO;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageService messageService;

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Message> updateMessage(@RequestBody MessageReplyDTO messageReplyDTO, @PathVariable long id) {
        Message updatedMessage = messageService.updateMessage(messageReplyDTO, id);
        return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
    }




} //Last curly bracket
