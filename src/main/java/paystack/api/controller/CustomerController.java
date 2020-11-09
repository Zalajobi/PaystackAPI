package paystack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paystack.api.constants.BaseURL;
import paystack.api.model.Customer;
import paystack.api.repository.CustomerRepo;
import paystack.api.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController extends BaseURL {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/register")
    private void saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @GetMapping(value = "/all")
    private List<Customer> allCustomer() {
//        return customerRepo.findAllByFirstname("Zhikrullah");
        return customerRepo.findAll();
    }
}
