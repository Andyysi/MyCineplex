package com.example.mycineplex.service;

import com.example.mycineplex.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    public Order createOrder(int id,Order order);

   public List<Order> getAllOrder();

    public Optional<Order> getOrderByUUID(UUID uuid);
    List<Order> createAll (int id, List<Order> orders);

}
