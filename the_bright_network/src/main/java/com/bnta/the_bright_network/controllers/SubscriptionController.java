package com.bnta.the_bright_network.controllers;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.models.SubscriptionDTO;
import com.bnta.the_bright_network.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Subscription> addPersonToChatroom(@RequestBody SubscriptionDTO subscriptionDTO){
        Subscription chatroom = subscriptionService.addNewUserToChatroom(subscriptionDTO);
        return new ResponseEntity<>(chatroom, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(){



        List<SubscriptionDTO> subscriptionDTOs = subscriptionService.displayAllSubscriptions()
                .stream()
                .map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
                .toList();

        return new ResponseEntity<>(subscriptionDTOs, HttpStatus.OK);
    }
}
