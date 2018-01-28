package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(method = RequestMethod.POST, value = "/app/visitor")
    public List<VisitorModel> addVisitor(VisitorModel visitorModel)
    {
        visitorService.addVisitorModel(visitorModel);
        return visitorService.getAllVisitors();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/app/visitor/{id}")
    public void deleteVisitor(@PathVariable String id)
    {
        visitorService.deleteVisitorModel(id);
    }
}
