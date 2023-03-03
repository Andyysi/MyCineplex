package com.example.mycineplex.service;

import com.example.mycineplex.entity.Customer;
import com.example.mycineplex.entity.Movie;
import com.example.mycineplex.entity.Order;
import com.example.mycineplex.exception.CustomerNotFoundException;
import com.example.mycineplex.exception.MovieNotFoundException;
import com.example.mycineplex.repo.OrderRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class OrderServiceImpl implements OrderService {

    private final OrderRepo repo;

    private final Customerservice customerservice;
    private final MovieService movieService;


    @Override
    public Order createOrder(int id, Order order) {
        Optional<Customer> customerbyId = customerservice.getCustomerbyId(id);
        Optional<Movie> movieById = movieService.getMovieById(order.getMovie().getId());
        log.debug("customer id {} provided to create order", id);
         Movie movie = movieById.orElseThrow(
                () -> new MovieNotFoundException(String.format("Movie with Id %d not found",order.getMovie().getId())));

         Customer customer = customerbyId.orElseThrow(
                 ()-> new CustomerNotFoundException(String.format("Customer with id %d not found",id)));

            order.setCustomer(customerbyId.get());
            order.setMovie(movieById.get());
            return repo.save(order);
    }

        @Override
        public List<Order> getAllOrder () {
            return repo.findAll();
        }

        @Override
        public Optional<Order> getOrderByUUID (UUID uuid){
            return repo.findById(uuid);
        }

        @Override
        public List<Order> createAll ( int id, List<Order > orders){
            Optional<Customer> customerById = customerservice.getCustomerbyId(id);
            Customer customer = customerById.orElseThrow(
                    () -> new CustomerNotFoundException(String.format("Customer with Id not found", id))
            );

            orders.forEach(order -> order.setCustomer(customer));
            //  public List<Order> createMultipleOrders(int id, List<Order> orders) {

            return repo.saveAll(orders);
        }
    }
