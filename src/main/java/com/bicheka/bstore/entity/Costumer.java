package com.bicheka.bstore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Costumer")
public class Costumer extends User{

    List<Item>shoppingcaCart;
}
