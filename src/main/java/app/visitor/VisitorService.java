package app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitorService {

    //region Services
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private VisitorRepository visitorRepository;
    //endregion

    public Set<VisitorEntity> getAllVisitors(Integer roomId)
    {
        return visitorRepository.findByRoomId(roomId);
    }

    public void registerNewVisitor(VisitorEntity visitorEntity)
    {
        //TODO try to find out existing visitor
        visitorRepository.save(visitorEntity);
        this.template.setUserDestinationPrefix("app");
        this.template.convertAndSend("/customer/visitors"+"/" + visitorEntity.getRoomId(), visitorEntity);
    }
}
