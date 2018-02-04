package app.customer;

import app.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void registerCustomer(@NotNull CustomerEntity customerEntity)
    {
        customerRepository.save(customerEntity);
    }
}
