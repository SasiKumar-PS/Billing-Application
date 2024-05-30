package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.models.Customer;

public interface CustomerService {
    Customer createCustomer();
    Customer getCustomer();
    Customer updateCustomer();
    String deleteCustomer();
}
