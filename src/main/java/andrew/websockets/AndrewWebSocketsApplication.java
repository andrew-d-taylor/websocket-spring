package andrew.websockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
public class AndrewWebSocketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndrewWebSocketsApplication.class, args);
	}
}
