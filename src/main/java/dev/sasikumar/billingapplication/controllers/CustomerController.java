package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.CustomerDto;
import dev.sasikumar.billingapplication.models.Customer;
import dev.sasikumar.billingapplication.services.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/")
    public Customer createCustomer(@RequestBody CustomerDto createCustomerDto) {
        return customerService.createCustomer(createCustomerDto);
    }

    @GetMapping("/{name}")
    public Customer getCustomer(@PathVariable("name") String businessName) {
        return customerService.getCustomer(businessName);
    }

    @PutMapping("/")
    public Customer updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/{name}")
    public String deleteCustomer(@PathVariable("name") String businessName) {
        return customerService.deleteCustomer(businessName);
    }
}
