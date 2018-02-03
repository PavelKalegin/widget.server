package app.visitor;

import app.chat.ChatService;
import app.chat.MessageModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("app/visitor")
public class VisitorRestController {
    @Autowired
    private VisitorService visitorService;

    @Autowired
    private ChatService chatService;

    @PostMapping("/register")
    public @ResponseBody String connect(@RequestBody VisitorEntity visitorEntity)
    {

        visitorService.addVisitorModel(visitorEntity);
        return visitorEntity.getId();
    }

    @PostMapping("/chat")
    public void send(@RequestBody MessageModel message)
    {
        chatService.sendMessageToRoom(message);
    }
}
