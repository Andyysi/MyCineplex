package com.example.mycineplex.rest;

import com.example.mycineplex.entity.Customer;
import com.example.mycineplex.service.Customerservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CustomerApi {
    private Customerservice customerservice;

    public CustomerApi(Customerservice customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping("/api/customer")
    public List<Customer> getAll(){
        return customerservice.getAllcustomer();


    }
    @PostMapping("/api/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setCreatedate(new Date());
        customer.setUpdatedate(new Date());
        return customerservice.Createcustomer(customer);
    }
}
