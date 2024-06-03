package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.converter.CustomerConverter;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/")
    public CustomerDto createCustomer(@RequestBody CustomerDto createCustomerDto) {
        return CustomerConverter.toCustomerDto(customerService.createCustomer(createCustomerDto));
    }

    @GetMapping("/{name}")
    public CustomerDto getCustomer(@PathVariable("name") String businessName) {
        return CustomerConverter.toCustomerDto(customerService.getCustomer(businessName));
    }

    @PutMapping("/")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return CustomerConverter.toCustomerDto(customerService.updateCustomer(customerDto));
    }

    @DeleteMapping("/{name}")
    public String deleteCustomer(@PathVariable("name") String businessName) {
        return customerService.deleteCustomer(businessName);
    }

    @GetMapping("/all")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers().stream().map(CustomerConverter::toCustomerDto).toList();
    }
}
