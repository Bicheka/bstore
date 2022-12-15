package com.bicheka.bstore.entity;

import java.util.Stack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "username", nullable = false)
    private String username;

    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Column(name = "cart", nullable = false)
    private Stack<Item> cart;


}
