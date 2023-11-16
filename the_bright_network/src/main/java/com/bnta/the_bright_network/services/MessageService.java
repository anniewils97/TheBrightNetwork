package com.bnta.the_bright_network.services;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.MessageDTO;
import com.bnta.the_bright_network.models.MessageReplyDTO;
import com.bnta.the_bright_network.models.Subscription;
import com.bnta.the_bright_network.repositories.MessageRepository;
import com.bnta.the_bright_network.repositories.SubscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;


    //Save a message in the db
    public Message saveMessage(Long chatRoomId, MessageDTO messageDTO) throws Exception {

        List<Subscription> optionalSubscription = subscriptionRepository.findByChatRoomIdAndUserId(chatRoomId, messageDTO.getuserId()); //findById(messageDTO.getSubscriptionId());
        if (optionalSubscription.isEmpty()){
            throw new Exception("this subscription does not exist");
        }

        Message message = new Message(
                messageDTO.getMessageContent(),
                optionalSubscription.get(0),
                LocalDateTime.now());
        messageRepository.save(message);
        return message;
    }

    public MessageReplyDTO updateMessage(MessageDTO messageDTO, long id) throws Exception{
        Optional<Message> messageToUpdateOptional = messageRepository.findById(id);
        if(messageToUpdateOptional.isEmpty()){
            throw new Exception("No message exists with this Id");
        }
        Message messageToUpdate = messageToUpdateOptional.get();
        messageToUpdate.setMessageContent(messageDTO.getMessageContent());
//        messageToUpdate.setTimeStamp(messageReplyDTO.getTimeStamp());
        messageRepository.save(messageToUpdate);

        MessageReplyDTO messageReply = new MessageReplyDTO(
                messageToUpdate.getId(),
                messageToUpdate.getSubscription().getUser().getName(),
                messageToUpdate.getMessageContent(),
                messageToUpdate.getTimeStamp().toString()
                );
        return messageReply;
    }

    public MessageReplyDTO deleteASpecificMessage(long id){
        Optional <Message> messages =  messageRepository.findById(id);
       if(messages.isPresent()){
           Message message = messages.get();
           String messageContent = message.getMessageContent();
           MessageReplyDTO deletedMessage = new MessageReplyDTO();
           deletedMessage.setMessageContent(messageContent);
           deletedMessage.setMessage_id(id);
           deletedMessage.setUsername(message.getSubscription().getUser().getName());
           deletedMessage.setTimeStamp(message.getTimeStamp().toString());
           messageRepository.deleteById(id);
           return deletedMessage;

       }
       return null;

    }



    //To get all messages
    public List<MessageReplyDTO> getAllMessages(){
        List<Message> messages = messageRepository.findAll();
        return convertListMessagesToDTOs(messages);
    }

    //Get all messages
    public List<MessageReplyDTO> getAllFilteredMessages(String keyword){
        List<Message> messages = messageRepository.findByMessageContentContainingIgnoreCase(keyword);
        return convertListMessagesToDTOs(messages);
    }

    //Create a function to convert a Message to MessageReplyDTO
    public List<MessageReplyDTO> convertListMessagesToDTOs(List<Message> messages){
        ArrayList<MessageReplyDTO> messageReplyDTOs = new ArrayList<>();
        //
        for (Message message: messages) {
            MessageReplyDTO messageReply = new MessageReplyDTO(
                    message.getId(),
                    message.getSubscription().getUser().getName(),
                    message.getMessageContent(),
                    message.getTimeStamp().toString()
            );
            //Fill the empty ArrayList messageReplyDTOs
            messageReplyDTOs.add(messageReply);
        }
        return messageReplyDTOs;
    }





} //Last curly bracket
