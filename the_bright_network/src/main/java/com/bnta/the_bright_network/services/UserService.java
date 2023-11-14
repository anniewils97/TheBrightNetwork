package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Displaying all users
    public List<User> displayAllUsers(){
        return userRepository.findAll();
    }

    //Getting users by their ID
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


} //End
