package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.models.SubscriptionDTO;
import com.bnta.the_bright_network.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> addPersonToChatroom(@RequestBody SubscriptionDTO subscriptionDTO){
        Subscription chatroom = subscriptionService.addNewUserToChatroom(subscriptionDTO);
        return new ResponseEntity<>(chatroom, HttpStatus.OK);

    }
}
