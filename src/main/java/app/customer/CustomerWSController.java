package app.customer;

import app.visitor.VisitorModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerWSController {

//    @MessageMapping("/visitor.add")
//    @SendTo("customer/visitors")
//    public VisitorModel addVisitor(VisitorModel visitorModel)
//    {
//        return visitorModel;
//    }
}
