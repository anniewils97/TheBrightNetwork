package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> displayAllUsers(){
        return userRepository.findAll();
    }


} //End
