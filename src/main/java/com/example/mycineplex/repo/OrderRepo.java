package com.example.mycineplex.repo;

import com.example.mycineplex.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface OrderRepo extends JpaRepository <Order, UUID> {
}
