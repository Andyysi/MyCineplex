package com.example.mycineplex.rest;

import com.example.mycineplex.entity.Customer;
import com.example.mycineplex.service.Customerservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerApi {
    private Customerservice customerservice;

    public CustomerApi(Customerservice customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping("/customer")
    public List<Customer> getAll(@RequestParam(name = "lastname", defaultValue = "abc") String lastname) {
        if (lastname.equals("abc")) {
            return customerservice.getAllcustomer();
        }
                return customerservice.getCustomerByLastname(lastname);
            }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setCreatedate(new Date());
        customer.setUpdatedate(new Date());
        return customerservice.Createcustomer(customer);
    }
    @PostMapping("/customers")
    public List<Customer> createAll (@RequestBody List<Customer> customers){
        customers.forEach(customer -> customer.setCreatedate(new Date()));
        customers.forEach(customer -> customer.setUpdatedate(new Date()));
        return customerservice.createAll(customers);
    }
    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById (@PathVariable int id ){
        return customerservice.getCustomerbyId(id);
    }
}
