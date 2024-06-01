package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.converter.CustomerConverter;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.repositorys.CustomerRepository;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerConverter.toCustomer(customerDto);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String businessName) {
        return customerRepository.getCustomerByBusinessName(businessName);
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        Customer updatedCustomer = CustomerConverter.toCustomer(customerDto);
        Customer customer = getCustomer(customerDto.getBusinessName());
        if(customer == null) throw new IllegalArgumentException("customer business name is invalid, please check and try again!");

        if(updatedCustomer.getId() == null) updatedCustomer.setId(customer.getId());
        if(updatedCustomer.getName() == null) updatedCustomer.setName(customer.getName());
        if(updatedCustomer.getPhoneNumber() == null) updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
        if(updatedCustomer.getAddress() == null) updatedCustomer.setAddress(customer.getAddress());
        if(updatedCustomer.getBalance() == null) updatedCustomer.setBalance(customer.getBalance());

        return customerRepository.save(updatedCustomer);
    }

    @Override
    public String deleteCustomer(String businessName) {
        customerRepository.deleteCustomerByBusinessName(businessName);
        return "Customer " + businessName + " is deleted!";
    }
}
