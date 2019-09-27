package andrew.websockets.resources;

import andrew.websockets.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin //allows any origin
public class MessageResource {

    private List<Message> messages;
    private static Message initialMessage = new Message("Note", "This is the default message", new Date().toLocaleString());

    public MessageResource() {
        messages = new ArrayList<>();
        messages.add(initialMessage);
    }

    @MessageMapping("/messages/create")
    @SendTo("/topic/messages")
    public Message createMessage(Message message) {
        messages.add(message);
        return message;
    }

    @RequestMapping("/messages")
    public @ResponseBody  List<Message> getMessages() {
        return messages;
    }

}
