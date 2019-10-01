package andrew.websockets.resources;

import andrew.websockets.model.Message;
import andrew.websockets.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that handles both REST requests and STOMP subscriptions for Messages
 */
@Controller
@CrossOrigin //allows any origin
public class MessageResource {

    private static final Logger LOG = LoggerFactory.getLogger(MessageResource.class.getSimpleName());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @SubscribeMapping("/messages")
    public List<Message> subscribeToMessages() {
        LOG.info("Handling subscription request to /app/messages");
        return (List<Message>)messageRepository.findAll();
    }

    @MessageMapping("/messages/create")
    @SendTo("/topic/messages")
    public Message createMessage(Message message) {
        LOG.info("Got a new message via STOMP: {}", message);
        return messageRepository.save(message);
    }

    @RequestMapping(path = "/messages", method = RequestMethod.GET)
    public @ResponseBody List<Message> getMessages() {
        return (List<Message>)messageRepository.findAll();
    }

    @RequestMapping(path = "/messages", method = RequestMethod.POST)
    public @ResponseBody Message createMessageREST(@RequestBody Message message) {
        LOG.info("Got a new message via REST: {}", message);
        simpMessagingTemplate.convertAndSend("/topic/messages", message);
        return messageRepository.save(message);
    }

}