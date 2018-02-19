package com.example.messenger.model;

/*
 * ChatMessage model is the message payload that will be 
 * exchanged between the clients and the server
 */
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    /*
     * Available types of message payload
     */
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
    
    /*
     * Method to get type of message
     */
    public MessageType getType() {
        return type;
    }
    /*
     * method to set type of message
     */
    public void setType(MessageType type) {
        this.type = type;
    }
    /*
     * method to get content of message
     */
    public String getContent() {
        return content;
    }
    /*
     * method to set content of message
     */
    public void setContent(String content) {
        this.content = content;
    }
    /*
     * method to get sender of message
     */
    public String getSender() {
        return sender;
    }
    /*
     * method to set sender of message
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
}
