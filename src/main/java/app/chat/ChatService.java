package app.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Service
public class ChatService {

    //region Services
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private MessageRepository messageRepository;
    //endregion

    public void sendMessageToRoom(@NotNull MessageEntity message)
    {
        messageRepository.save(message);
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/chat"+"/" + message.getRoomId(), message);
    }

    public void sendMessageToVisitor(@NotNull MessageEntity message)
    {
        messageRepository.save(message);
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/chat"+"/"
                + message.getRoomId() + "/"
                + message.getVisitorId(), message);
    }

    public Set<MessageEntity> getVisitorMessages(String visitorId)
    {
        return messageRepository.findByVisitorId(visitorId);
    }
}
