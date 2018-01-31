package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {

    @Autowired
    private SimpMessagingTemplate template;


    private List<VisitorModel> visitorModels = new ArrayList<>();

    public List<VisitorModel> getAllVisitors()
    {
        return visitorModels;
    }

    public void addVisitorModel(VisitorModel visitorModel)
    {
        visitorModels.add(visitorModel);
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/customer/visitors"+"/" + visitorModel.getRoomID(),visitorModel);
    }

    public void deleteVisitorModel(String id)
    {
        //TODO implement this logic
//        visitorModels.remove(visitorModels.stream().
//                filter(m -> m.getId().equals(id))
//                .findAny().get());
    }
}
