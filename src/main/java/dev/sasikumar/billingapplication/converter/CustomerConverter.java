package dev.sasikumar.billingapplication.converter;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;

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
}
