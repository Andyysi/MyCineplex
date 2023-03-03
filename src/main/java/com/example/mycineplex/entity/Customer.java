package com.example.mycineplex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(unique = true,nullable = false)

    private String email;
    private String login;
    @Column(unique = true)
    private String password;
    @Transient
    private Boolean IsLoggedIn;
    private Date createdate;
    private Date updatedate;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
