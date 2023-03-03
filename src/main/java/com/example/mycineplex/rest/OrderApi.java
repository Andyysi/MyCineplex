package com.example.mycineplex.rest;

import com.example.mycineplex.Dto.Errordto;
import com.example.mycineplex.entity.Order;
import com.example.mycineplex.exception.CustomerNotFoundException;
import com.example.mycineplex.exception.MovieNotFoundException;
import com.example.mycineplex.service.Customerservice;
import com.example.mycineplex.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ScatteringByteChannel;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/customer")

public class OrderApi {
    private final OrderService service;

    public OrderApi(OrderService service, Customerservice customerservice) {
        this.service = service;

    }


    @PostMapping("/{id}/order")
    public ResponseEntity<Order> createorder(@RequestHeader(value = "X-COUNTRY", required = false) String country,@PathVariable int id, @RequestBody Order order) {
        Order serviceOrder = service.createOrder(id, order);
        log.info("processing information provided by the header", country);
        if (country.equals("INDIA")) {
            serviceOrder.setTotalAmount(serviceOrder.getTotalAmount()*60);
        }
        return ResponseEntity.status(HttpStatus.CREATED).header("X","MyCineplex").body(serviceOrder);
    }
    @PostMapping("/{id}/orders")
    public List<Order> createAll(@PathVariable int id, @RequestBody List<Order> orders) {

        return service.createAll(id, orders );
    }
    @GetMapping("/orders")
    public List<Order> getAll (){
        return service.getAllOrder();
    }
}
