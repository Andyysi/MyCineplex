package com.example.mycineplex.repo;

import com.example.mycineplex.entity.Customer;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository <Customer, Integer>{
    public List<Customer> getCustomersByLastname(String lastname);
}


