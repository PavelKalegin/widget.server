package app.visitor;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
public class VisitorRestController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(method = RequestMethod.POST,value = "app/visitor/{roomID}")
    public void connect(@PathVariable String roomID, @RequestBody Map<String,String> parameters, HttpServletRequest request)
    {
        visitorService.addVisitorModel(new VisitorModel(request.getSession().getId(),parameters.get("name"), roomID));
    }

}
