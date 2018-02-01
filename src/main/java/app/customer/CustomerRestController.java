package app.customer;

import app.chat.ChatService;
import app.chat.MessageModel;
import app.visitor.VisitorModel;
import app.visitor.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("app/customer")
public class CustomerRestController {

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private ChatService chatService;

    @PostMapping("/connect/{roomID}")
    public String connect(@PathVariable String roomID)
    {
        return roomID;
    }

    @PostMapping("/chat")
    public void send(@RequestBody MessageModel message)
    {
        chatService.sendMessageToVisitor(message);
    }

    @GetMapping("/visitors")
    public List<VisitorModel> getAllVisitors()
    {
        return visitorService.getAllVisitors();
    }
}
