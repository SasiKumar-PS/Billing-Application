package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    Customer getCustomerByBusinessName(String businessName);
    void deleteCustomerByBusinessName(String businessName);
}
