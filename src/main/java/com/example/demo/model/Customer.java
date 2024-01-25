package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @Column(name = "store_id", nullable = false, unique = true)
    private String storeId;

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String lastUpdate;

    @Column(name = "address_id", nullable = false, unique = true)
    private String addressId;

    @Column(name = "active", nullable = false, unique = true)
    private String active;

    @Column(name = "create_date", nullable = false, unique = true)
    private String createDate;

    @Column(name = "last_update", nullable = false, unique = true)
    private String last_Update;

}