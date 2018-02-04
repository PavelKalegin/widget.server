package app.customer;

import app.chat.ChatService;
import app.chat.MessageEntity;
import app.room.RoomEntity;
import app.room.RoomService;
import app.visitor.VisitorEntity;
import app.visitor.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("app/customer")
public class CustomerRestController {

    //region Services
    @Autowired
    private VisitorService visitorService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private RoomService roomService;
    //endregion

    //region POST Methods
    @PostMapping("/register")
    public Integer registerCustomer(@RequestBody CustomerEntity customerEntity)
    {
        //TODO oAuth registering
        customerService.registerCustomer(customerEntity);
        return customerEntity.getId();
    }

    @PostMapping("{customerId}/addRoom")
    public void registerRoom(@PathVariable Integer customerId)
    {
        roomService.registerRoom(customerId);
    }

    @PostMapping("/connect/{customerID}")
    public String connect(@PathVariable Integer customerId)
    {
        //TODO return customerID for next work
        return customerId.toString();
    }

    @PostMapping("/chat")
    public void send(@RequestBody MessageEntity message)
    {
        chatService.sendMessageToVisitor(message);
    }
    //endregion

    //region GET Methods
    @GetMapping("{customerId}/rooms")
    public Set<RoomEntity> getRooms(@PathVariable String customerId)
    {
        return roomService.getCustomerRooms(Integer.parseInt(customerId));
    }

    @GetMapping("{roomId}/visitors")
    public Set<VisitorEntity> getAllVisitors(@PathVariable(value = "roomId") Integer roomId)
    {
        return visitorService.getAllVisitors(roomId);
    }
    //endregion
}
