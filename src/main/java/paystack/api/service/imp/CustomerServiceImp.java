package paystack.api.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paystack.api.model.customer.Customer;
import paystack.api.repository.CustomerRepo;
import paystack.api.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void save(Customer customer) {
//        customer.setId(Long.valueOf(UUID.randomUUID().toString()));
        customerRepo.save(customer);
    }
}
