package com.example.mycineplex.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TABLE_ORDER")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID") @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String MovieName;
    private String OrderDate;
    private String Showdate;
    private Double TotalAmount;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;


}
