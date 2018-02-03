package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitorService {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private VisitorRepository visitorRepository;


    public Set<VisitorEntity> getAllVisitors(Integer roomId)
    {
        return visitorRepository.findByRoomId(roomId);
    }

    public void addVisitorModel(VisitorEntity visitorEntity)
    {
        visitorRepository.save(visitorEntity);
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/customer/visitors"+"/" + visitorEntity.getRoomId(), visitorEntity);
    }

    public void deleteVisitorModel(String id)
    {
        //TODO implement this logic
    }
}
