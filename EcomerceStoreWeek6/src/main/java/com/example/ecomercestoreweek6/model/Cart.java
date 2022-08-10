package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private int product_id;
    private int product_quantity;
    private Timestamp created_at;

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product_id=" + product_id +
                ", product_quantity=" + product_quantity +
                ", created_at=" + created_at +
                '}';
    }
}
