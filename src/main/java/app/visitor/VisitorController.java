package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @MessageMapping("visitor.add")
    @SendTo("/customer/visitors")
    public VisitorModel addVisitor(VisitorModel visitorModel)
    {
        visitorService.addVisitorModel(visitorModel);
        return visitorModel;
    }
}
