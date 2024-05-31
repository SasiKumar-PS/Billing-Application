package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.repositorys.CustomerRepository;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setBusinessName(customerDto.getBusinessName());
        customer.setName(customer.getName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setBalance(customerDto.getBalance());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String businessName) {
        return customerRepository.getCustomerByBusinessName(businessName);
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
