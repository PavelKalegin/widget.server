package app.visitor;

import app.chat.ChatService;
import app.chat.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("app/visitor")
public class VisitorRestController {
    //region Services
    @Autowired
    private VisitorService visitorService;

    @Autowired
    private ChatService chatService;
    //endregion

    @PostMapping("/register")
    public @ResponseBody String connect(@RequestBody VisitorEntity visitorEntity)
    {
        visitorService.registerNewVisitor(visitorEntity);
        return visitorEntity.getId();
    }

    @PostMapping("/chat")
    public void send(@RequestBody MessageEntity message)
    {
        chatService.sendMessageToRoom(message);
    }

    @GetMapping("chat/{visitorId}")
    public Set<MessageEntity> getVisitorMessages(@PathVariable String visitorId)
    {
        return chatService.getVisitorMessages(visitorId);
    }
}
