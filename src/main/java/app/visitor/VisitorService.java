package app.visitor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {

    private List<VisitorModel> visitorModels = new ArrayList<>();

    public List<VisitorModel> getAllVisitors()
    {
        return visitorModels;
    }

    public void addVisitorModel(VisitorModel visitorModel)
    {
        visitorModels.add(visitorModel);
    }

    public void deleteVisitorModel(String id)
    {
        visitorModels.remove(visitorModels.stream().
                filter(m -> m.getId().equals(id))
                .findAny().get());
    }
}
