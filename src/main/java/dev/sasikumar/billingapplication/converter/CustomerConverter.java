package dev.sasikumar.billingapplication.converter;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;

import java.util.List;

public class CustomerConverter {

    public static Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setName(customerDto.getName());
        customer.setBusinessName(customerDto.getBusinessName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setBalance(customerDto.getBalance());

        return customer;
    }

    public static CustomerDto toCustomerDto (Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setName(customer.getName());
        customerDto.setBusinessName(customer.getBusinessName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setAddress(customer.getAddress());
        customerDto.setBalance(customer.getBalance());

        return customerDto;
    }

    public static List<CustomerDto> toCustomerDtoList (List<Customer> customers) {
        return customers.stream().map(CustomerConverter::toCustomerDto).toList();
    }

    public static void updateValues(Customer updatedCustomer, Customer customerFromDB) {
        if(updatedCustomer.getId() == null) updatedCustomer.setId(customerFromDB.getId());
        if(updatedCustomer.getName() == null) updatedCustomer.setName(customerFromDB.getName());
        if(updatedCustomer.getPhoneNumber() == null) updatedCustomer.setPhoneNumber(customerFromDB.getPhoneNumber());
        if(updatedCustomer.getAddress() == null) updatedCustomer.setAddress(customerFromDB.getAddress());
        if(updatedCustomer.getBalance() == 0) updatedCustomer.setBalance(customerFromDB.getBalance());
    }
}
