package com.bicheka.bstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "seller_id", nullable = false)
    private long sellerId;

    @NonNull
    @Column(name = "itemName", nullable = false)
    private String itemName;

    @NonNull
    @Column(name = "itemPrice", nullable = false)
    private double itemPrice;

    @NonNull
    @Column(name = "itemDescription", nullable = false)
    private String itemDescription;


    @NonNull
    @Column(name = "amountInStock", nullable = false)
    private long amountInStock;
    
}
