package com.example.mycineplex.service;

import com.example.mycineplex.entity.Customer;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

public interface Customerservice {
    public Customer Createcustomer(Customer customer);

    List<Customer> getAllcustomer();

    Optional<Customer> getCustomerbyId(Integer id);
    List<Customer> createAll(List<Customer> customers);
    List<Customer> getCustomerByLastname(String lastname);
}