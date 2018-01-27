package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/app/visitor")
    public String sayHi()
    {
        return "Hi";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/app/visitor")
    public void addVisitor(@RequestBody VisitorModel visitorModel)
    {
        visitorService.addVisitorModel(visitorModel);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/app/visitor/{id}")
    public void deleteVisitor(@PathVariable String id)
    {
        visitorService.deleteVisitorModel(id);
    }
}
