package com.example.ecomercestoreweek6.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor

public class Cart  {
    private int quantity;
    private int productId;
    private int userId;
    private String productName;



    public Cart() {

    }

    @Override
    public String toString() {
        return "Cart{" +
                "quantity=" + quantity +
                ", productId=" + productId +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
