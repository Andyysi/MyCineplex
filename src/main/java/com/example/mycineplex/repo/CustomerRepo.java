package com.example.mycineplex.repo;

import com.example.mycineplex.entity.Customer;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepo extends JpaRepository <Customer, Integer>{
}


