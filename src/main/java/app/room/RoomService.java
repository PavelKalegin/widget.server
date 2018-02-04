package app.room;

import app.customer.CustomerEntity;
import app.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Set<RoomEntity> getCustomerRooms(Integer customerId)
    {
        return roomRepository.findByCustomerId(customerId);
    }

    public void registerRoom(Integer customerId)
    {
        //TODO handle incorrect customerId
        CustomerEntity customer = customerRepository.findOne(customerId);
        RoomEntity room = new RoomEntity(customer.getName() + " room " + ThreadLocalRandom.current().nextInt());
        room.setCustomer(customer);
        roomRepository.save(room);
    }
}
