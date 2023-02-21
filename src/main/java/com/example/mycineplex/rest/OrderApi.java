package com.example.mycineplex.rest;

import com.example.mycineplex.entity.Order;
import com.example.mycineplex.service.Customerservice;
import com.example.mycineplex.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")

public class OrderApi {
    private final OrderService service;

    public OrderApi(OrderService service, Customerservice customerservice) {
        this.service = service;

    }


    @PostMapping("/{id}/order")
    public Order createorder(@PathVariable("id") int id, @RequestBody Order order) {
        return service.createOrder(id, order);

    }
    @PostMapping("/{id}/orders")
    public List<Order> createAll(@PathVariable("id") int id, @RequestBody List<Order> orders) {
        return service.createAll(id, orders );
    }
    @GetMapping("/orders")
    public List<Order> getAll (){
        return service.getAllOrder();
    }
}
