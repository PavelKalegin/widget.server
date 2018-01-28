package app.customer;

import app.visitor.VisitorModel;
import app.visitor.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping("app/customer/visitors")
    public List<VisitorModel> getAllVisitors()
    {
        return visitorService.getAllVisitors();
    }
}
