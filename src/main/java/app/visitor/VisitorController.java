package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    //@RequestMapping(method = RequestMethod.POST, value = "/app/visitor")
    @MessageMapping("/visitor.addVisitor")
    @SendTo("/customer/visitors")
    public List<VisitorModel> addVisitor(VisitorModel visitorModel)
    {
        visitorService.addVisitorModel(visitorModel);
        return visitorService.getAllVisitors();
    }

//    @RequestMapping(method = RequestMethod.DELETE,value = "/app/visitor/{id}")
//    public void deleteVisitor(@PathVariable String id)
//    {
//        visitorService.deleteVisitorModel(id);
//    }
}
