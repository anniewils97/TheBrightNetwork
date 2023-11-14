package com.bnta.the_bright_network.controllers;

import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    UserService userService;


    //Getting all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.displayAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Display a user by ID
    @GetMapping (value = "/{id}")
    public ResponseEntity<User> getAUserById(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


} //end
