package dev.sasikumar.billingapplication.services.Impl;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.converter.CustomerConverter;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.repositorys.CustomerRepository;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Customer customerFromDB = getCustomer(customerDto.getBusinessName());
        if(customerFromDB == null) throw new IllegalArgumentException("customer business name is invalid, please check and try again!");

        CustomerConverter.updateValues(updatedCustomer, customerFromDB);

        return customerRepository.save(updatedCustomer);
    }

    @Override
    public String deleteCustomer(String businessName) {
        customerRepository.deleteCustomerByBusinessName(businessName);
        return "Customer " + businessName + " is deleted!";
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
