package app.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class ChatService {
    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessageToRoom(@NotNull MessageModel message)
    {
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/chat"+"/" + message.getRoomID(),message);
    }

    public void sendMessageToVisitor(@NotNull MessageModel message)
    {
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/chat"+"/" + message.getRoomID() + "/"  + message.getVisitorID(),message);
    }
}
