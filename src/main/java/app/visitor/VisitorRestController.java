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

    @PostMapping("/{roomID}")
    public @ResponseBody Map<String,String> connect(@PathVariable String roomID, @RequestBody Map<String,String> parameters, HttpServletRequest request)
    {

        visitorService.addVisitorModel(new VisitorModel(request.getSession().getId(),parameters.get("name"), roomID));
        Map<String, String> response = new HashMap<>();
        response.put("id",request.getSession().getId());
        return response;
    }

    @PostMapping("/send")
    public void send(@RequestBody MessageModel message)
    {
        chatService.sendMessageToRoom(message);
    }
}
