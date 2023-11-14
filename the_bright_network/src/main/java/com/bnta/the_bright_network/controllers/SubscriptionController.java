package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.Subscription;
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

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Subscription> addPersonToChatroom(@RequestBody Subscription subscription, @PathVariable long id){
        long userId = subscription.getId();
        Subscription chatroom = subscriptionService.addNewUserToChatroom(id, userId);
        return new ResponseEntity<>(chatroom, HttpStatus.OK);


    }
}
