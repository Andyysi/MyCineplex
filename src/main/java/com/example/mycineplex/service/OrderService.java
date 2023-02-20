package com.example.mycineplex.service;

import com.example.mycineplex.entity.Order;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    public Order createOrder(int cust_id,Order order);

   public List<Order> getAllOrder();

    public Optional<Order> getOrderByUUID(UUID uuid);
    List<Order> createAll (List<Order> order);

}
