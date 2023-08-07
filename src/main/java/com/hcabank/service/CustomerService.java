package com.hcabank.service;

import com.hcabank.controller.request.CustomerRequest;
import com.hcabank.data.model.Customer;
import com.hcabank.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Boolean createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .address(customerRequest.getAddress())
                .age(customerRequest.getAge())
                .name(customerRequest.getName())
                .social(customerRequest.getSocial())
                .build();
        Customer customerEntity = customerRepository.save(customer);
        return Boolean.TRUE;

    }

    public Customer getCustomer(String customerName) {
    return customerRepository.findByName(customerName);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Boolean removeCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.findByName(customerRequest.getName());
        customerRepository.delete(customer);
        return Boolean.TRUE;
    }

}
