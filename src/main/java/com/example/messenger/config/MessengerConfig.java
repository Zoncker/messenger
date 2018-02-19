package com.example.messenger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/*
 * Indicates that a class declares one or more @Bean methods 
 * and may be processed by the Spring container
 */
@Configuration
/*
 * Enable web-socket server
 */
@EnableWebSocketMessageBroker
public class MessengerConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	/*
	 * Register a web-socket end-point that the clients will 
	 * use to connect to our web-socket server
	 */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	/* withSockJS() for browsers that don’t support web-socket*/
        registry.addEndpoint("/ws").withSockJS();
    }
    
    /*
     * Configuring a message broker that will be used to route 
     * messages from one client to another
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	/* 
    	 * Messages whose destination starts with "/app" should be routed 
    	 * to message-handling methods
    	 */
        registry.setApplicationDestinationPrefixes("/app");
        /* 
         * And, the second line defines that the messages whose destination 
         * starts with “/topic” should be routed to the message broker. 
         * Message broker broadcasts messages to all the connected clients 
         * who are subscribed to a particular topic.
         */
        registry.enableSimpleBroker("/topic");
    }
}
