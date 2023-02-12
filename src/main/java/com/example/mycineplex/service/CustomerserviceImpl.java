package com.example.mycineplex.service;

import com.example.mycineplex.entity.Customer;
import com.example.mycineplex.exception.UnsupportedLoginNameException;
import com.example.mycineplex.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerserviceImpl implements Customerservice {
    private CustomerRepo repo;

    public CustomerserviceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public Customer Createcustomer(Customer customer) {
        if (customer.getLogin() == null)
            throw new UnsupportedLoginNameException("Login name cannot be Null");
        return repo.save(customer);
    }

    @Override
    public List<Customer> getAllcustomer() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerbyId(Integer id) {
        return repo.findById(id);
    }

    public List<Customer> createAll(List<Customer> customers) {
        return repo.saveAll(customers);
    }

    public List<Customer> getCustomerByLastname(String lastname) {
        return repo.getCustomersByLastname(lastname);
    }
}