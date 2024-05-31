package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Customer getCustomer(String businessName) {
        return null;
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public String deleteCustomer(String businessName) {
        return null;
    }
}
