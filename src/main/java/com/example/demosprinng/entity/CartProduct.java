package com.example.demosprinng.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@Entity
public class CartProduct {
    @Id
    private Long id;
    private Long cartId;
    private Long productId;
    private int Quantity;
}
