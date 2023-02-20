package com.example.mycineplex.service;

import com.example.mycineplex.entity.Customer;
import com.example.mycineplex.entity.Order;
import com.example.mycineplex.exception.CustomerNotFoundException;
import com.example.mycineplex.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {

    private final OrderRepo repo;

    private final Customerservice customerservice;

    @Override
    public Order createOrder(int cust_id,Order order) {
        Optional<Customer> customerbyId = customerservice.getCustomerbyId(cust_id);
        if (customerbyId.isPresent()) {
         return repo.save(order);
        }
        else{
            throw new CustomerNotFoundException(String.format("Customer with this id Does not Exist"),cust_id);
        }
    }

    @Override
    public List<Order> getAllOrder() {
        return repo.findAll();
    }

    @Override
    public Optional<Order> getOrderByUUID(UUID uuid) {
        return repo.findById(uuid);
    }

    @Override
    public List<Order> createAll(List<Order> order) {
        return repo.saveAll(order);
    }
}
