package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;

public interface CustomerService {
    Customer createCustomer(CustomerDto customerDto);
    Customer getCustomer(String businessName);
    Customer updateCustomer(CustomerDto customerDto);
    String deleteCustomer(String businessName);
}
