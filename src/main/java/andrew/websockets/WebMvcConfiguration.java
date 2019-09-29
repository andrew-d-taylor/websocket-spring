package andrew.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVC-related configuration for the application
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    protected static final String STOMP_REGISTRY_ENDPOINT = "/andrew-stomp-endpoint";

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

}
