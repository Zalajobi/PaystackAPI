package paystack.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import paystack.api.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {
    List<Customer> findAllByFirstname(String firstname);
}
