package app.customer;

import app.visitor.VisitorModel;
import app.visitor.VisitorService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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

    @PostMapping("/connect/{roomID}")
    public String connect(@PathVariable String roomID)
    {
        return roomID;
    }

    @GetMapping("/visitors")
    public List<VisitorModel> getAllVisitors()
    {
        return visitorService.getAllVisitors();
    }
}
