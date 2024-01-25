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
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staff_id;

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "address_id", nullable = false, unique = true)
    private String addressId;

    @Column(name = "picture", nullable = false, unique = true)
    private String picture;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "store_id", nullable = false, unique = true)
    private String storeId;

    @Column(name = "active", nullable = false, unique = true)
    private String active;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "last_update", nullable = false, unique = true)
    private String last_Update;

}