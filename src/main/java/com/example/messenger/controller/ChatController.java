package com.example.messenger.controller;

import com.example.messenger.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	/*
	 * Mapping a Message onto message-handling methods 
	 * by matching to the message destination
	 */
    @MessageMapping("/chat.sendMessage")
    /*
     * Indicates a method's return value should be converted
     * to a Message if necessary and sent to the specified 
     * destination.
     */
    @SendTo("/topic/public")
    /*
     * Return chatMessage instance
     */
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    /*
     * Add username in web socket session attributes
     * headerAccessor give access to header map interface
     */
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
    	/*
    	 *  Put username to attributes of session
    	 */
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
