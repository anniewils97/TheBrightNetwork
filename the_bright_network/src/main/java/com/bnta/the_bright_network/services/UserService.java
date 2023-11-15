package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.User;
import com.bnta.the_bright_network.models.UserDTO;
import com.bnta.the_bright_network.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Displaying all users
    public List<UserDTO> displayAllUsers(){
        List <User> users =  userRepository.findAll();
        List <UserDTO> userDTOs = new ArrayList<>();
        for(User user : users ){
            UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getAge(),user.getRole());
           userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    //Getting users by their ID
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //Create a new user in the db
    public User createNewUser(User user){
        return userRepository.save(user);
    }


} //End
