package andrew.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Websocket configuration for the application
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final String TOPIC_DEST_PREFIX = "/topic";
    private static final String APPLICATION_DEST_PREFIX = "/app";
    private static final String STOMP_REGISTRY_ENDPOINT = "/websocket-stomp-endpoint";

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(TOPIC_DEST_PREFIX);
        registry.setApplicationDestinationPrefixes(APPLICATION_DEST_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(STOMP_REGISTRY_ENDPOINT+"/*").setAllowedOrigins("*").withSockJS();
    }
}
