package paystack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import paystack.api.constants.BaseURL;
import paystack.api.core.ApiQuery;
import paystack.api.model.customer.Customer;
import paystack.api.repository.CustomerRepo;
import paystack.api.service.CustomerService;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController extends BaseURL {

    @Autowired
    @Qualifier(value = "apiQuery")
    private ApiQuery apiQuery;

    @GetMapping(value = CUSTOMER + "/all")
    private Map<String, Object> allCustomer() {
        return apiQuery.getConnectAndQuery(CUSTOMER_API);
    }

    @GetMapping(value = CUSTOMER + "/find")
    private Map<String, Object> findCustomer(@RequestParam(name = "id") String id) {
        return apiQuery.getConnectAndQuery(CUSTOMER_API + id);
    }

    @PostMapping(value = CUSTOMER + "/create")
    private Map<String, Object> createCustomer(@ModelAttribute Customer customer) {
        return apiQuery.connectAndQuery(customer.asMap(), CUSTOMER_API);
    }

    @PutMapping(value = CUSTOMER + "/update")
    private Map<String, Object> updateCustomer(@RequestParam(name = "id") String id, @ModelAttribute Customer customer) {
        return apiQuery.connectAndQueryWithPut(customer.asMap(), CUSTOMER_API + id);
    }

    @PostMapping(value = CUSTOMER + "/action")
    private Map<String, Object> action(@ModelAttribute Customer customer) {
//        System.out.println(customer.getId());
        return apiQuery.connectAndQuery(customer.asMap(), CUSTOMER_API + "set_risk_action");
    }
}
