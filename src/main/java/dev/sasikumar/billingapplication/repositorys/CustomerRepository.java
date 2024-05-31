package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    Customer getCustomerByBusinessName(String businessName);
}
