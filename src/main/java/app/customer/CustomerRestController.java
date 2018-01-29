package app.customer;

import app.visitor.VisitorModel;
import app.visitor.VisitorService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(method = RequestMethod.POST,value = "app/customer/connect/{roomID}")
    public String connect(@PathVariable String roomID)
    {
        return roomID;
    }

    @RequestMapping("app/customer/visitors")
    public List<VisitorModel> getAllVisitors()
    {
        return visitorService.getAllVisitors();
    }
}
