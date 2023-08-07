package com.hcabank.controller;

import com.hcabank.controller.request.CustomerRequest;
import com.hcabank.data.model.Customer;
import com.hcabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Boolean createCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);

    }
    @GetMapping("/{name}")
    public Customer getCustomer(@PathVariable("name") String name) {
        return customerService.getCustomer(name);

    }
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();

    }

    @DeleteMapping
    public Boolean deleteCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.removeCustomer(customerRequest);

    }

}
